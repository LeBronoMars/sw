package com.denr.solidwaste.ui.home.maps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentMapsBinding;

import javax.inject.Inject;

public class MapsFragment extends BaseFragment<FragmentMapsBinding, MapsFragmentViewModel>
        implements MapsFragmentNavigator {

    @Inject
    MapsFragmentViewModel mapsFragmentViewModel;

    public static MapsFragment newInstance() {
        Bundle args = new Bundle();
        MapsFragment fragment = new MapsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final WebView webView = view.findViewById(R.id.web_view);
        webView.loadUrl("https://philippineenvironmentconnect.org/");
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_maps;
    }

    @Override
    public MapsFragmentViewModel getViewModel() {
        return mapsFragmentViewModel;
    }

    @Override
    public void onViewMap(int index) {
        if (index == 0) {

        }
    }
}
