package com.uwacoding.app.codelabs.core.iklan_saya;

import android.support.v7.widget.RecyclerView;

import com.ahmadrosid.lib.baseapp.core.BaseView;

/**
 * Created by Firman on 3/29/2017.
 */

public interface IklanSayaView extends BaseView {
    void showMessage(String messages);
    void setDataIklan(RecyclerView.Adapter adapter);
    void dismishrefresh();
}
