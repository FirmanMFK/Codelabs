package com.uwacoding.app.codelabs.core.welcome.login;

import android.content.Intent;

import com.ahmadrosid.lib.baseapp.core.BaseView;

/**
 * Created by Firman on 3/29/2017.
 */

public interface LoginView extends BaseView {
    void startResult(Intent signInIntent, int rcSignIn);
    void successLogin();
    void failedLogin();
}
