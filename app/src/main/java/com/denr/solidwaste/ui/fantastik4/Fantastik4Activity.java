package com.denr.solidwaste.ui.fantastik4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityFantastik4Binding;
import com.denr.solidwaste.ui.composting.CompostingActivity;
import com.denr.solidwaste.ui.idolkosikap.IdolKoSiKapActivity;
import com.denr.solidwaste.ui.ra9003.Ra9003Activity;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;
import com.synnapps.carouselview.CarouselView;

import javax.inject.Inject;

public class Fantastik4Activity extends BaseActivity<ActivityFantastik4Binding, Fantastik4ViewModel>
        implements Fantastik4Navigator {

    private static final int STORY_SIZE = 14;

    @Inject
    Fantastik4ViewModel fantastik4ViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.site_list_menu_2));

        initCarouselView();
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
        return R.layout.activity_fantastik_4;
    }

    @Override
    public Fantastik4ViewModel getViewModel() {
        return fantastik4ViewModel;
    }

    @Override
    public void onPlayVideo() {
        showToastMessage("On Play video here");
    }

    @Override
    public void onViewPrevSite() {
        startActivity(new Intent(this, IdolKoSiKapActivity.class));
        finish();
    }

    @Override
    public void onViewNextSite() {
        startActivity(new Intent(this, CompostingActivity.class));
        finish();
    }

    private void initCarouselView() {
        CarouselView carouselView = getViewDataBinding().carouselView;

        carouselView.setPageCount(STORY_SIZE);

        carouselView.setImageListener((position, imageView) ->
                Glide.with(this)
                        .load(String.format("https://s3-ap-southeast-1.amazonaws.com/solid-waste/story_%d.jpg", (position + 1)))
                        .apply(new RequestOptions().placeholder(R.color.placeholder))
                        .into(imageView));
    }
}
