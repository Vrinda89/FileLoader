package com.loader.pro.di.module;


import com.loader.pro.di.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

 @Module(includes = {ViewModelModule.class})
 public class AppModule {

    @Provides
    @Singleton
    DataManager provideDataManager(){
        return  new DataManager();
    }

}
