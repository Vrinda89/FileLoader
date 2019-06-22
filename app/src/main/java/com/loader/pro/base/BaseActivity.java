package com.loader.pro.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.loader.pro.di.BaseViewModel;


public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    protected T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for setting binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();


    /**
     * @return layout resource id
     */
    public abstract @LayoutRes
    int getLayoutId();


    /**
     * Override for setting viewModel
     *
     * @return view model instance
     */
    public abstract V getViewModel();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();

    }

    private void performDataBinding() {

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setLifecycleOwner(this);
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(),mViewModel);
        mViewDataBinding.executePendingBindings();

    }

}
