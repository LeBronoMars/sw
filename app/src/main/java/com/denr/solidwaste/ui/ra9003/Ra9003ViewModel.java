package com.denr.solidwaste.ui.ra9003;

import android.databinding.ObservableField;

import com.denr.solidwaste.base.BaseViewModel;
import com.denr.solidwaste.base.Constant;

public class Ra9003ViewModel extends BaseViewModel<Ra9003Navigator> {

    private ObservableField<String> ra9003image1;
    private ObservableField<String> ra9003image2;
    private ObservableField<String> ra9003image3;

    public Ra9003ViewModel() {
        this.ra9003image1 = new ObservableField<>(Constant.REPUBLIC_ACT_2003_1);
        this.ra9003image2 = new ObservableField<>(Constant.REPUBLIC_ACT_2003_2);
        this.ra9003image3 = new ObservableField<>(Constant.REPUBLIC_ACT_2003_3);
    }

    public ObservableField<String> getRa9003image1() {
        return ra9003image1;
    }

    public ObservableField<String> getRa9003image2() {
        return ra9003image2;
    }

    public ObservableField<String> getRa9003image3() {
        return ra9003image3;
    }

    public void onPlayVideo() {
        getNavigator().onPlayVideo();
    }

    public void onViewNextSite() {
        getNavigator().onViewNextSite();
    }

}
