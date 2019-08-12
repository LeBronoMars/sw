package com.denr.solidwaste.ui.composting;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.databinding.ActivityCompostingBinding;
import com.denr.solidwaste.ui.welcome.WelcomeActivity;
import com.synnapps.carouselview.CarouselView;

import javax.inject.Inject;

public class CompostingActivity extends BaseActivity<ActivityCompostingBinding,
        CompostingViewModel> implements CompostingNavigator {

    private int[] drawableRes = new int[] {
            R.drawable.composting_1,
            R.drawable.composting_2,
            R.drawable.composting_3,
            R.drawable.composting_4,
        };

    private Drawable[] drawables = new Drawable[drawableRes.length];

    @Inject
    CompostingViewModel compostingViewModel;

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
        return R.layout.activity_composting;
    }

    @Override
    public CompostingViewModel getViewModel() {
        return compostingViewModel;
    }

    @Override
    public void onViewPrevSite() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < drawableRes.length; i++) {
            drawables[i] = ContextCompat.getDrawable(this, drawableRes[i]);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.site_list_menu_6));

        initCarouselView();
    }

    @Override
    public void onViewNextSite() {
    }

    private void initCarouselView() {
        CarouselView carouselView = getViewDataBinding().carouselView;

        carouselView.setPageCount(drawableRes.length);

        carouselView.setImageListener((position, imageView) ->
                Glide.with(this)
                        .load(drawables[position])
                        .apply(new RequestOptions().placeholder(R.color.placeholder))
                        .into(imageView));
    }
}
