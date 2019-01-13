package com.denr.solidwaste.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.base.BaseFragmentPagerAdapter;
import com.denr.solidwaste.databinding.ActivityHomeBinding;
import com.denr.solidwaste.ui.home.info.InfoFragment;
import com.denr.solidwaste.ui.home.maps.MapsFragment;
import com.denr.solidwaste.ui.home.sites.SitesFragment;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;

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
        getSupportActionBar().setTitle(getString(R.string.bnve_maps));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.navigation_home:
                startActivity(new Intent(this, WelcomeActivity.class));
                finish();
                return true;
        }
        return true;
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
        fragments.add(MapsFragment.newInstance());
        fragments.add(SitesFragment.newInstance());
        fragments.add(InfoFragment.newInstance());

        pagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments);

        getViewDataBinding().vpHome.setAdapter(pagerAdapter);

        getViewDataBinding().vpHome.setOffscreenPageLimit(fragments.size());

        getViewDataBinding().bottomNavigationViewEx.setupWithViewPager(getViewDataBinding().vpHome);

        getViewDataBinding().vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    getSupportActionBar().setTitle(getString(R.string.bnve_maps));
                } else if (i == 1) {
                    getSupportActionBar().setTitle(getString(R.string.bnve_keypad));
                } else if (i == 2) {
                    getSupportActionBar().setTitle(getString(R.string.bnve_info));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
