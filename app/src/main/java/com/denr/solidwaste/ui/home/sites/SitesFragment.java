package com.denr.solidwaste.ui.home.sites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentSitesBinding;

import javax.inject.Inject;

public class SitesFragment extends BaseFragment<FragmentSitesBinding, SitesFragmentViewModel>
        implements SitesFragmentNavigator {

    @Inject
    SitesFragmentViewModel sitesFragmentViewModel;

    public static SitesFragment newInstance() {
        Bundle args = new Bundle();
        SitesFragment fragment = new SitesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sites;
    }

    @Override
    public SitesFragmentViewModel getViewModel() {
        return sitesFragmentViewModel;
    }

    @Override
    public void onSiteListAction(int index) {

    }
}
