package com.denr.solidwaste.ui.home.sites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentSitesBinding;
import com.denr.solidwaste.ui.basurakid.BasuraKidActivity;
import com.denr.solidwaste.ui.fantastik4.Fantastik4Activity;
import com.denr.solidwaste.ui.idolkosikap.IdolKoSiKapActivity;
import com.denr.solidwaste.ui.ra9003.Ra9003Activity;

import javax.inject.Inject;

public class SitesFragment extends BaseFragment<FragmentSitesBinding, SitesFragmentViewModel>
        implements SitesFragmentNavigator {

    @Inject
    SitesFragmentViewModel sitesFragmentViewModel;

    public static SitesFragment newInstance() {
        Bundle args = new Bundle();
        SitesFragment fragment = new SitesFragment();
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
        return R.layout.fragment_sites;
    }

    @Override
    public SitesFragmentViewModel getViewModel() {
        return sitesFragmentViewModel;
    }

    @Override
    public void onSiteListAction(int index) {
        switch (index) {
            case 0:
                startActivity(new Intent(getActivity(), Ra9003Activity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), Fantastik4Activity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), BasuraKidActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), IdolKoSiKapActivity.class));
                break;
        }
    }
}
