package com.loader.pro.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.loader.loader3.JsonResponseListener;
import com.loader.loader3.MFileLoader;
import com.loader.loader3.MLoaderResponse;
import com.loader.pro.BR;
import com.loader.pro.R;
import com.loader.pro.adapter.ProfileAdapter;
import com.loader.pro.base.BaseActivity;
import com.loader.pro.databinding.ActivityMainBinding;
import com.loader.pro.model.ProfileResponse;
import com.loader.pro.utils.NetWorkUtils;
import com.loader.pro.viewmodel.MainViewModel;

import java.util.Arrays;

import javax.inject.Inject;


public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    private static String URL = "http://pastebin.com/raw/wgkJgazE";

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchJsonData(URL);
    }



    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    private void fetchJsonData(String url) {
        if(!NetWorkUtils.isNetworkConnected(this)){
            Toast.makeText(this,"Please check your network connection and try again",Toast.LENGTH_SHORT).show();
        }
        MFileLoader.getInstance().loadJson(url, new JsonResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                if(mLoaderResponse!=null && !TextUtils.isEmpty(mLoaderResponse.getJsonResponse())){
                    Gson gson = new Gson();
                    ProfileResponse.Profile[] profileResponse = gson.fromJson(mLoaderResponse.getJsonResponse(), ProfileResponse.Profile[].class);
                    ProfileAdapter adapter = new ProfileAdapter(Arrays.asList(profileResponse));
                    mViewDataBinding.profilesRV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mViewDataBinding.profilesRV.setAdapter(adapter);
                }
            }
        });

    }
}
