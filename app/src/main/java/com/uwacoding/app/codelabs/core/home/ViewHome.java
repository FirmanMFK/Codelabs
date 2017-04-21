package com.uwacoding.app.codelabs.core.home;

import android.support.v7.widget.RecyclerView;

import com.ahmadrosid.lib.baseapp.core.BaseView;

/**
 * Created by Firman on 3/29/2017.
 */

public interface ViewHome extends BaseView {
    void setDataIklan(RecyclerView.Adapter adapter);
    void showMessage(String message);
    void dismishrefresh();
}
