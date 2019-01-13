package com.denr.solidwaste.ui.home.info;

import com.denr.solidwaste.base.BaseViewModel;

public class InfoFragmentViewModel extends BaseViewModel<InfoFragmentNavigator> {

    public void onInfoAction(int index) {
        getNavigator().onInfoAction(index);
    }
}
