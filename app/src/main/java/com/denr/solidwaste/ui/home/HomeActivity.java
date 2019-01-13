package com.denr.solidwaste.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.base.BaseFragmentPagerAdapter;
import com.denr.solidwaste.databinding.ActivityHomeBinding;
import com.denr.solidwaste.ui.home.fragment.HomeFragment;
import com.denr.solidwaste.ui.home.sites.SitesFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel>
        implements HomeNavigator, HasSupportFragmentInjector {

    @Inject
    HomeViewModel homeViewModel;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private BaseFragmentPagerAdapter pagerAdapter;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragments();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        return homeViewModel;
    }

    private void initFragments() {
        fragments.add(SitesFragment.newInstance());
        fragments.add(SitesFragment.newInstance());
        fragments.add(SitesFragment.newInstance());
        fragments.add(SitesFragment.newInstance());

        pagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments);

        getViewDataBinding().vpHome.setAdapter(pagerAdapter);

        getViewDataBinding().vpHome.setOffscreenPageLimit(fragments.size());

        getViewDataBinding().bottomNavigationViewEx.setupWithViewPager(getViewDataBinding().vpHome);
    }
}
