package com.loader.pro.di;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * Base for all viewModel
 *
 * @param <N>
 */

public abstract class BaseViewModel<N> extends ViewModel {


    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private final DataManager mDataManager;

    private WeakReference<N> mNavigator;

    protected BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public DataManager getmDataManager() {
        return mDataManager;
    }

    public void setNavigator(N mNavigator) {
        this.mNavigator = new WeakReference<>(mNavigator);
    }


    public N getmNavigator() {
        return mNavigator.get();
    }
}
