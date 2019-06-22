package com.loader.pro.viewmodel;

import com.loader.pro.di.BaseViewModel;
import com.loader.pro.di.DataManager;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }
}
