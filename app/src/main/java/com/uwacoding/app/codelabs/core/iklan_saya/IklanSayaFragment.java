package com.uwacoding.app.codelabs.core.iklan_saya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ahmadrosid.lib.baseapp.core.BaseFragment;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.core.iklan_saya.newiklan.NewIklanActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Firman on 3/29/2017.
 */

public class IklanSayaFragment extends BaseFragment implements IklanSayaView {

    @BindView(R.id.loader)
    ProgressBar loader;
    @BindView(R.id.list_iklan_saya)
    RecyclerView list_iklan_saya;
    @BindView(R.id.empty)
    TextView empty;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private IklanSayaFragmentPresenter presenter;

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_iklan_saya;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        presenter= new IklanSayaFragmentPresenter(this);
        presenter.loadIklanSaya();

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    private void refreshData() {
        presenter.refreshIklan();
    }

    private void finishLoad(){
        loader.setVisibility(View.GONE);
        empty.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.add_new_iklan) void clickNewIklan(){
        open(NewIklanActivity.class);
    }

    @Override
    public void showMessage(String messages) {
        alert(messages);
    }

    @Override
    public void setDataIklan(RecyclerView.Adapter adapter) {
        list_iklan_saya.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        list_iklan_saya.setAdapter(adapter);
    }

    @Override
    public void dismishrefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void startLoading() {
        try {
            loader.setVisibility(View.VISIBLE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void stopLoading(){
        loader.setVisibility(View.GONE);
    }


    @Override
    public void onStop(){
        super.onStop();
        presenter.detachView();
    }
}
