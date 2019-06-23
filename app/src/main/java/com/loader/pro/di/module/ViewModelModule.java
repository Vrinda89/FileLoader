package com.loader.pro.di.module;


import androidx.lifecycle.ViewModel;

import com.loader.pro.base.key.ViewModelKey;
import com.loader.pro.viewmodel.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
/**
 * Module specifically for adding all view models in the app
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    abstract ViewModel bindMainViewModel(ProfileViewModel viewModel);



}
