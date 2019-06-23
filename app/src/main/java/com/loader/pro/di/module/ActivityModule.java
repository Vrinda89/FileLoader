package com.loader.pro.di.module;


import com.loader.pro.view.ProfileActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Module specifically for adding all activities in the app
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract ProfileActivity contributeMainActivity();
}
