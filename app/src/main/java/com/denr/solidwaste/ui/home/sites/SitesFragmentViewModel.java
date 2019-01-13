package com.denr.solidwaste.ui.home.sites;

import android.databinding.ObservableField;

import com.denr.solidwaste.base.BaseViewModel;
import com.denr.solidwaste.base.Constant;

public class SitesFragmentViewModel extends BaseViewModel<SitesFragmentNavigator> {

    private ObservableField<String> siteImageUrl;

    public SitesFragmentViewModel() {
        this.siteImageUrl = new ObservableField<>(Constant.SITE_IMAGE_URL);
    }

    public ObservableField<String> getSiteImageUrl() {
        return siteImageUrl;
    }

    public void onSiteListAction(int index) {
        getNavigator().onSiteListAction(index);
    }
}
