package com.uwacoding.app.codelabs.core.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.lib.baseapp.core.BaseFragment;
import com.ahmadrosid.lib.baseapp.helper.ImageViewHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.core.welcome.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Firman on 3/29/2017.
 */

public class ProfileFragment extends BaseFragment {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.image_profile)
    ImageView image_profile;
    @BindView(R.id.email)
    TextView email;

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_profile;
    }


    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        name.setText(user.getDisplayName());
        ImageViewHelper.createRounded(getContext(), user.getPhotoUrl().toString(), image_profile);
        email.setText(user.getEmail());
    }

    @OnClick(R.id.logout) void clickLogout(){
        FirebaseAuth.getInstance().signOut();
        open(LoginActivity.class);
        finish();
    }
}
