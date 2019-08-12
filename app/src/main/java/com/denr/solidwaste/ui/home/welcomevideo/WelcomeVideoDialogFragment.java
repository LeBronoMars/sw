package com.denr.solidwaste.ui.home.welcomevideo;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.denr.solidwaste.R;
import com.denr.solidwaste.base.Constant;

public class WelcomeVideoDialogFragment extends DialogFragment {

    public static final String TAG = WelcomeVideoDialogFragment.class.getName();

    private View view;

    private Dialog dialog;

    public static WelcomeVideoDialogFragment newInstance() {
        final WelcomeVideoDialogFragment fragment = new WelcomeVideoDialogFragment();
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
                .inflate(R.layout.dialog_fragment_welcome_video, null);

        dialog = new Dialog(getActivity());

        final VideoView videoView = view.findViewById(R.id.video_view);

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName()
                + "/" + R.raw.welcome_video);
        videoView.setVideoURI(uri);
        videoView.start();

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);

        return dialog;
    }
}
