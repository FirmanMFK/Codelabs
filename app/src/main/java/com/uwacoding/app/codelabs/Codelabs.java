package com.uwacoding.app.codelabs;

import android.app.Application;

import com.ahmadrosid.lib.baseapp.BaseApp;

/**
 * Created by Firman on 3/29/2017.
 */

public class Codelabs extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApp.init(this);
    }
}
