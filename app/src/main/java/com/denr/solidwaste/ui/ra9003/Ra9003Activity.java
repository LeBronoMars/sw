package com.denr.solidwaste.ui.ra9003;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityRa9003Binding;
import com.denr.solidwaste.ui.basurakid.BasuraKidActivity;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;

import javax.inject.Inject;

public class Ra9003Activity extends BaseActivity<ActivityRa9003Binding, Ra9003ViewModel>
        implements Ra9003Navigator {

    @Inject
    Ra9003ViewModel ra9003ViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.ra_9003_toolbar_title));
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
        startActivity(new Intent(this, BasuraKidActivity.class));
        finish();
    }
}
