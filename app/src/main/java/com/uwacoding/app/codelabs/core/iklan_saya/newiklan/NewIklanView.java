package com.uwacoding.app.codelabs.core.iklan_saya.newiklan;

import android.app.Activity;

import com.ahmadrosid.lib.baseapp.core.BaseView;

/**
 * Created by Firman on 3/29/2017.
 */

public interface NewIklanView extends BaseView {
    Activity getActivity();
    void finishAddNewIklan();
}
