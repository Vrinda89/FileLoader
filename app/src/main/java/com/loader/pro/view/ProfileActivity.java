package com.loader.pro.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.loader.pro.BR;
import com.loader.pro.R;
import com.loader.pro.adapter.ProfileAdapter;
import com.loader.pro.base.BaseActivity;
import com.loader.pro.databinding.ActivityMainBinding;
import com.loader.pro.model.ProfileResponse;
import com.loader.pro.utils.Utils;
import com.loader.pro.viewmodel.ProfileViewModel;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class ProfileActivity extends BaseActivity<ActivityMainBinding, ProfileViewModel> {

    private static String URL = "http://pastebin.com/raw/wgkJgazE";

    @Inject
    ProfileViewModel profileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        observeResponse();
        fetchJsonData(URL);
    }

    private void observeResponse() {
        profileViewModel.response.observe(this, new Observer<ProfileResponse.Profile[]>() {
            @Override
            public void onChanged(ProfileResponse.Profile[] profiles) {
                if (profiles != null) {
                    bindData(Arrays.asList(profiles));
                }
            }
        });
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
    public ProfileViewModel getViewModel() {
        return profileViewModel;
    }

    private void fetchJsonData(String url) {
        if (!Utils.isNetworkConnected(this)) {
            Toast.makeText(this, R.string.str_network_error, Toast.LENGTH_SHORT).show();
            return;
        } else {
            profileViewModel.fetchResponse(url);
        }


    }

    public void bindData(List<ProfileResponse.Profile> profileResponse) {
        ProfileAdapter adapter = new ProfileAdapter(profileResponse);
        mViewDataBinding.profilesRV.setLayoutManager(new LinearLayoutManager(ProfileActivity.this));
        mViewDataBinding.profilesRV.setAdapter(adapter);
    }
}
