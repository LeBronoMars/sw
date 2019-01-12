package com.denr.solidwaste.base;

public interface BaseNavigator {

    void showProgressDialog();

    void dismissProgressDialog();

    void showErrorMessage(String errorMessage);

    void onDismiss();
}
