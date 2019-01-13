package com.denr.solidwaste.ui.ra9003;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityRa9003Binding;

import javax.inject.Inject;

public class Ra9003Activity extends BaseActivity<ActivityRa9003Binding, Ra9003ViewModel>
        implements Ra9003Navigator {

    @Inject
    Ra9003ViewModel ra9003ViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ra_9003;
    }

    @Override
    public Ra9003ViewModel getViewModel() {
        return ra9003ViewModel;
    }

    @Override
    public void onPlayVideo() {
        showToastMessage("On Play video here");
    }

    @Override
    public void onViewNextSite() {
        showToastMessage("On view Fantastic 4 screen here");
    }
}
