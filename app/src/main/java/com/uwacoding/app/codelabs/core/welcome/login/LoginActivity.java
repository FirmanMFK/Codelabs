package com.uwacoding.app.codelabs.core.welcome.login;

import android.content.Intent;
import android.os.Bundle;

import com.ahmadrosid.lib.baseapp.core.BaseActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.core.home.HomeActivity;

import butterknife.OnClick;

/**
 * Created by Firman on 3/29/2017.
 */

public class LoginActivity extends BaseActivity implements LoginView{

    private static final String TAG = "LoginActivity";
    private static final int RC_SIGN_IN = 9001;
    private LoginPresenter presenter;


    @Override
    protected int getResourceLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        presenter = new LoginPresenter(this, this);
        presenter.loadConfig();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                presenter.firebaseAuthWithGoogle(account);
            } else {
                alert("Failed login with Google Please Try Again");
            }
        }
    }

    @Override public void startResult(Intent signInIntent, int rcSignIn) {
        startActivityForResult(signInIntent, rcSignIn);
    }

    @Override public void successLogin() {
        open(HomeActivity.class);
        finish();
    }

    @Override public void failedLogin() {
        alert("Failed to login please try again.");
    }

    @Override public void startLoading() {
        showLoading();
    }

    @Override public void stopLoading() {
        hideLoading();
    }

    @OnClick(R.id.signin_google) void clickGoogle() {
        presenter.signIn();
    }

    @Override protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
