package com.denr.solidwaste.ui.home.info.contactus;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denr.solidwaste.R;

public class ContactUsDialogFragment extends DialogFragment {

    private View view;

    private Dialog dialog;

    private OnContactUsListener onContactUsListener;

    public static ContactUsDialogFragment newInstance() {
        final ContactUsDialogFragment fragment = new ContactUsDialogFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_fragment_contact_us, null);

        dialog = new Dialog(getActivity());

        final TextView tvAddress = view.findViewById(R.id.tv_address);
        final TextView tvTelephone = view.findViewById(R.id.tv_telephone);
        final TextView tvEmail = view.findViewById(R.id.tv_email);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);

        tvAddress.setOnClickListener(v -> {
            if (null != onContactUsListener) {
                onContactUsListener.onViewAddress(tvAddress.getText().toString());
            }
        });

        tvTelephone.setOnClickListener(v -> {
            if (null != onContactUsListener) {
                onContactUsListener.onDial(tvTelephone.getText().toString());
            }
        });

        tvEmail.setOnClickListener(v -> {
            if (null != onContactUsListener) {
                onContactUsListener.onSendEmail(tvEmail.getText().toString());
            }
        });

        view.findViewById(R.id.ll_follow_on_fb).setOnClickListener(v -> {
            if (null != onContactUsListener) {
                onContactUsListener.onFollowOnFb();
            }
        });

        view.findViewById(R.id.ll_follow_on_twitter).setOnClickListener(v -> {
            if (null != onContactUsListener) {
                onContactUsListener.onFollowOnTwitter();
            }
        });

        return dialog;
    }

    public void setOnContactUsListener(OnContactUsListener onContactUsListener) {
        this.onContactUsListener = onContactUsListener;
    }
}
