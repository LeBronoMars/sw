package com.denr.solidwaste.ui.basurakid;

import android.databinding.ObservableArrayList;

import com.denr.solidwaste.base.BaseViewModel;

public class BasuraKidViewModel extends BaseViewModel<BasuraKidNavigator> {

    private ObservableArrayList<String> images;

    public BasuraKidViewModel() {
        this.images = new ObservableArrayList<>();

        for (int i = 0; i < 6; i++) {
            this.images.add(String.format("https://s3-ap-southeast-1.amazonaws.com/solid-waste/basura_kid_%d.jpg", (i+1)));
        }
    }

    public void onPlayVideo() {
        getNavigator().onPlayVideo();
    }

    public void onViewNextSite() {
        getNavigator().onViewNextSite();
    }

    public void onViewPrevSite() {
        getNavigator().onViewPrevSite();
    }

    public ObservableArrayList<String> getImages() {
        return images;
    }
}
