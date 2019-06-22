package com.loader.pro.di.module;


import androidx.lifecycle.ViewModel;

import com.loader.pro.base.key.ViewModelKey;
import com.loader.pro.viewmodel.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);



}
