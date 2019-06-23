package com.loader.pro.viewmodel;

import com.google.gson.Gson;
import com.loader.loader3.JsonResponseListener;
import com.loader.loader3.MFileLoader;
import com.loader.loader3.MLoaderResponse;
import com.loader.loader3.MLoaderStatus;
import com.loader.pro.base.SingleLiveEvent;
import com.loader.pro.di.BaseViewModel;
import com.loader.pro.di.DataManager;
import com.loader.pro.model.ProfileResponse;

import javax.inject.Inject;

public class ProfileViewModel extends BaseViewModel {


    public SingleLiveEvent<ProfileResponse.Profile[]> response = new SingleLiveEvent<>();

    @Inject
    public ProfileViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void fetchResponse(String url) {
        MFileLoader.getInstance().loadJson(url, new JsonResponseListener() {
            @Override
            public void onResponse(MLoaderResponse mLoaderResponse) {
                if (mLoaderResponse != null && mLoaderResponse.getStatus() == MLoaderStatus.SUCCESS) {
                    Gson gson = new Gson();
                    ProfileResponse.Profile[] profileResponse = gson.fromJson(mLoaderResponse.getJsonResponse(), ProfileResponse.Profile[].class);
                    response.setValue(profileResponse);
                }
            }
        });
    }
}
