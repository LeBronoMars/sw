package com.denr.solidwaste.ui.home.maps;

import com.denr.solidwaste.base.BaseViewModel;

public class MapsFragmentViewModel extends BaseViewModel<MapsFragmentNavigator> {

    public void onViewMap(int index) {
        getNavigator().onViewMap(index);
    }
}
