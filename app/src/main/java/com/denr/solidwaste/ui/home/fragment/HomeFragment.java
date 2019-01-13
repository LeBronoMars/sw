package com.denr.solidwaste.ui.home.fragment;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentHomeBinding;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeFragmentViewModel> {

    @Inject
    HomeFragmentViewModel homeFragmentViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeFragmentViewModel getViewModel() {
        return homeFragmentViewModel;
    }
}
