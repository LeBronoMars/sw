package com.denr.solidwaste.ui.basurakid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.base.Constant;
import com.denr.solidwaste.databinding.ActivityBasuraKidBinding;
import com.denr.solidwaste.ui.fantastik4.Fantastik4Activity;
import com.denr.solidwaste.ui.ra9003.Ra9003Activity;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;
import com.synnapps.carouselview.CarouselView;

import javax.inject.Inject;

public class BasuraKidActivity extends BaseActivity<ActivityBasuraKidBinding, BasuraKidViewModel>
        implements BasuraKidNavigator {

    private static final int STORY_SIZE = 5;

    @Inject
    BasuraKidViewModel basuraKidViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.site_list_menu_3));

        initCarouselView();

        getViewDataBinding().videoView.setVideoURI(Uri.parse(Constant.BASURA_KID_VIDEO));
        getViewDataBinding().videoView.start();
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
        return R.layout.activity_basura_kid;
    }

    @Override
    public BasuraKidViewModel getViewModel() {
        return basuraKidViewModel;
    }

    @Override
    public void onPlayVideo() {
        showToastMessage("On Play video here");
    }

    @Override
    public void onViewPrevSite() {
        startActivity(new Intent(this, Fantastik4Activity.class));
        finish();
    }

    @Override
    public void onViewNextSite() {
        showToastMessage("On view Fantastic 4 screen here");
    }

    private void initCarouselView() {
        CarouselView carouselView = getViewDataBinding().carouselView;

        carouselView.setPageCount(STORY_SIZE);

        carouselView.setImageListener((position, imageView) ->
                Glide.with(this)
                        .load(String.format("https://s3-ap-southeast-1.amazonaws.com/solid-waste/basura_kid_carousel_%d.jpg", (position + 1)))
                        .apply(new RequestOptions().placeholder(R.color.placeholder))
                        .into(imageView));
    }
}
