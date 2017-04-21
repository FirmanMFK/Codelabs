package com.uwacoding.app.codelabs.core.welcome;

import android.os.Bundle;
import android.os.Handler;

import com.ahmadrosid.lib.baseapp.core.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.core.home.HomeActivity;
import com.uwacoding.app.codelabs.core.welcome.login.LoginActivity;

/**
 * Created by Firman on 3/29/2017.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected int getResourceLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        new Handler().postDelayed(this::checkAuth, 2500);
    }

    private void checkAuth() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            open(HomeActivity.class);
        } else {
            open(LoginActivity.class);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }
}
