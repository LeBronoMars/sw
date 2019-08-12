package com.denr.solidwaste.ui.composting;

import com.denr.solidwaste.base.BaseViewModel;

public class CompostingViewModel extends BaseViewModel<CompostingNavigator> {

    public CompostingViewModel() {
    }

    public void onViewNextSite() {
        getNavigator().onViewNextSite();
    }

    public void onViewPrevSite() {
        getNavigator().onViewPrevSite();
    }
}
