package com.denr.solidwaste.ui.home.fragment;

import android.os.Bundle;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentHomeBinding;
import com.denr.solidwaste.ui.home.sites.SitesFragment;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeFragmentViewModel> {

    @Inject
    HomeFragmentViewModel homeFragmentViewModel;

    public static SitesFragment newInstance() {
        Bundle args = new Bundle();
        SitesFragment fragment = new SitesFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
