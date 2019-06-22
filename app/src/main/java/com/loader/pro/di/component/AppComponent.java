package com.loader.pro.di.component;


import android.app.Application;

import com.loader.pro.base.ProApplication;
import com.loader.pro.di.module.ActivityModule;
import com.loader.pro.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * all modules to be injected is specified here
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityModule.class})
public interface AppComponent {

    void inject(ProApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
