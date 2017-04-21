package com.uwacoding.app.codelabs;

import android.os.Bundle;

import com.ahmadrosid.lib.baseapp.core.BaseActivity;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Firman on 3/29/2017.
 */

public class TestActivity extends BaseActivity {

    private static final String  TAG = "TestActivity";
    private DatabaseReference mIklanReference;

    @Override
    protected int getResourceLayout() {
        return R.layout.blank_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
