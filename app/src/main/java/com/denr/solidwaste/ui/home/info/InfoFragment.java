package com.denr.solidwaste.ui.home.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentInfoBinding;

import javax.inject.Inject;

public class InfoFragment extends BaseFragment<FragmentInfoBinding, InfoFragmentViewModel>
        implements InfoFragmentNavigator {

    @Inject
    InfoFragmentViewModel infoFragmentViewModel;

    public static InfoFragment newInstance() {
        Bundle args = new Bundle();
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_info;
    }

    @Override
    public InfoFragmentViewModel getViewModel() {
        return infoFragmentViewModel;
    }

    @Override
    public void onInfoAction(int index) {

    }
}
