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
        switch (index) {
            case 0:
                HoursAndAdmissionDialogFragment.newInstance()
                        .show(getChildFragmentManager(), "hours");
                break;
            case 1:
                showContactUsDialogFragment();
                break;
            case 2:
                SurveyDialogFragment.newInstance().show(getChildFragmentManager(), "survey");
                break;
            case 3:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://philippineenvironmentconnect.org/about-us/"));
                startActivity(browserIntent);
//                BecomeAMemberHereDialogFragment.newInstance()
//                        .show(getChildFragmentManager(), "member");
                break;
            case 4:
                BlogDialogFragment.newInstance().show(getChildFragmentManager(), "blog");
                break;
            case 5:
                AboutThisAppDialogFragment.newInstance().show(getChildFragmentManager(), "about");
                break;
        }
    }

    private void showContactUsDialogFragment() {
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
                openUrlInBrowser("https://www.facebook.com/Philippine-Environment-Connect-687975338272466");
            }

            @Override
            public void onFollowOnTwitter() {
                openUrlInBrowser("https://twitter.com/EMBPhilEnviron1");
            }
        });
        dialogFragment.show(getChildFragmentManager(), "contact us");
    }

    private void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
