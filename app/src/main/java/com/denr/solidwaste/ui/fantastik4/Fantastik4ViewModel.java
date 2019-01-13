package com.denr.solidwaste.ui.fantastik4;

import android.databinding.ObservableField;

import com.denr.solidwaste.base.BaseViewModel;
import com.denr.solidwaste.base.Constant;

public class Fantastik4ViewModel extends BaseViewModel<Fantastik4Navigator> {

    private ObservableField<String> image1;

    public Fantastik4ViewModel() {
        this.image1 = new ObservableField<>(Constant.FANTASTIK_4);
    }

    public ObservableField<String> getImage1() {
        return image1;
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

}
