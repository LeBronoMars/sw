package com.denr.solidwaste.ui.home.info.contactus;

public interface OnContactUsListener {

    void onViewAddress(String address);

    void onDial(String telephone);

    void onSendEmail(String email);

    void onFollowOnFb();

    void onFollowOnTwitter();
}
