package com.denr.solidwaste.ui.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityWelcomeBinding;

import javax.inject.Inject;

public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding, WelcomeViewModel>
        implements WelcomeNavigator {

    @Inject
    WelcomeViewModel welcomeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public WelcomeViewModel getViewModel() {
        return welcomeViewModel;
    }
}
