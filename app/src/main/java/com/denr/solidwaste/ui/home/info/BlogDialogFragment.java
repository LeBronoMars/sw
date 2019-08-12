package com.denr.solidwaste.ui.home.info;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.denr.solidwaste.R;

public class BlogDialogFragment extends DialogFragment {

    private View view;

    private Dialog dialog;

    public static BlogDialogFragment newInstance() {
        final BlogDialogFragment fragment = new BlogDialogFragment();
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
                .inflate(R.layout.dialog_fragment_blog, null);

        dialog = new Dialog(getActivity());

        view.findViewById(R.id.ll_follow_on_fb).setOnClickListener(view ->
                openUrlInBrowser("https://www.facebook.com/Philippine-Environment-Connect-687975338272466"));

        view.findViewById(R.id.ll_follow_on_twitter).setOnClickListener(view ->
                openUrlInBrowser("https://twitter.com/EMBPhilEnviron1"));

        view.findViewById(R.id.ll_follow_on_youtube).setOnClickListener(view ->
                openUrlInBrowser("https://www.youtube.com/channel/UCgqS6v6tWEnK-BEm8awfCgQ"));

        view.findViewById(R.id.ll_follow_on_instagram).setOnClickListener(view ->
                openUrlInBrowser("https://www.instagram.com/phil_environment_connect/"));

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);

        return dialog;
    }

    private void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
