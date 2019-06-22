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


    private final DataManager mDataManager;


    protected BaseViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }



}
