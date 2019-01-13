package com.denr.solidwaste.ui.home.info;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.denr.solidwaste.R;
import com.denr.solidwaste.base.BaseActivity;

public class SurveyDialogFragment extends DialogFragment {

    private View view;

    private Dialog dialog;

    public static SurveyDialogFragment newInstance() {
        final SurveyDialogFragment fragment = new SurveyDialogFragment();
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
                .inflate(R.layout.dialog_fragment_survey, null);

        dialog = new Dialog(getActivity());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);

        final RadioButton rbYes = view.findViewById(R.id.rb_yes);
        final RadioButton rbNo = view.findViewById(R.id.rb_no);

        view.findViewById(R.id.btn_save).setOnClickListener(v -> {
            ((BaseActivity) getActivity()).showToastMessage(getString(R.string.thank_you));
            dismiss();
        });

        rbYes.setOnClickListener(v -> {
                rbYes.setChecked(true);
                rbNo.setChecked(false);
            });

        rbNo.setOnClickListener(v -> {
                rbYes.setChecked(false);
                rbNo.setChecked(true);
            });
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();

        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = (int) (getDeviceMetrics().widthPixels * 0.9);
        params.height = (int) (getDeviceMetrics().heightPixels * 0.9);

        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    private DisplayMetrics getDeviceMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }
}
