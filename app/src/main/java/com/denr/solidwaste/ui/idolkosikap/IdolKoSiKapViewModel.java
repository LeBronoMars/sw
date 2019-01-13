package com.denr.solidwaste.ui.idolkosikap;

import android.databinding.ObservableArrayList;

import com.denr.solidwaste.base.BaseViewModel;

public class IdolKoSiKapViewModel extends BaseViewModel<IdolKoSiKapNavigator> {

    private ObservableArrayList<String> images;

    public IdolKoSiKapViewModel() {
        this.images = new ObservableArrayList<>();

        for (int i = 0; i < 3; i++) {
            this.images.add(String.format("https://s3-ap-southeast-1.amazonaws.com/solid-waste/kap_%d.jpg", (i+1)));
        }
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
