package com.denr.solidwaste.ui.idolkosikap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityIdolKoSiKapBinding;
import com.denr.solidwaste.ui.basurakid.BasuraKidActivity;
import com.denr.solidwaste.ui.fantastik4.Fantastik4Activity;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;

import javax.inject.Inject;

public class IdolKoSiKapActivity extends BaseActivity<ActivityIdolKoSiKapBinding, IdolKoSiKapViewModel>
        implements IdolKoSiKapNavigator {

    @Inject
    IdolKoSiKapViewModel idolKoSiKapViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.site_list_menu_4));
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
        return R.layout.activity_idol_ko_si_kap;
    }

    @Override
    public IdolKoSiKapViewModel getViewModel() {
        return idolKoSiKapViewModel;
    }

    @Override
    public void onViewPrevSite() {
        startActivity(new Intent(this, BasuraKidActivity.class));
        finish();
    }

    @Override
    public void onViewNextSite() {
        startActivity(new Intent(this, Fantastik4Activity.class));
    }
}
