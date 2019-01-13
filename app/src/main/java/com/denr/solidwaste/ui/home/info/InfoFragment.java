package com.denr.solidwaste.ui.home.info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.denr.solidwaste.BR;
import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;
import com.denr.solidwaste.base.BaseFragment;
import com.denr.solidwaste.databinding.FragmentInfoBinding;
import com.denr.solidwaste.ui.home.info.contactus.ContactUsDialogFragment;
import com.denr.solidwaste.ui.home.info.contactus.OnContactUsListener;

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
        if (index == 0) {
            HoursAndAdmissionDialogFragment.newInstance().show(getChildFragmentManager(), "hours");
        } else if (index == 1) {
            ContactUsDialogFragment dialogFragment = ContactUsDialogFragment.newInstance();
            dialogFragment.setOnContactUsListener(new OnContactUsListener() {
                @Override
                public void onViewAddress(String address) {
                    final String map = "http://maps.google.co.in/maps?q=" + address;
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(map)));
                }

                @Override
                public void onDial(String telephone) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + telephone));
                    startActivity(intent);
                }

                @Override
                public void onSendEmail(String email) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, email);

                    startActivity(Intent.createChooser(intent, "Send Email"));
                }

                @Override
                public void onFollowOnFb() {
                    ((BaseActivity) getActivity()).showToastMessage("Follow on facebook here");
                }

                @Override
                public void onFollowOnTwitter() {
                    ((BaseActivity) getActivity()).showToastMessage("Follow on twitter here");
                }
            });
            dialogFragment.show(getChildFragmentManager(), "contact us");
        }
    }
}
