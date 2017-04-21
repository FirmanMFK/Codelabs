package com.uwacoding.app.codelabs.core.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.ahmadrosid.lib.baseapp.core.BaseFragment;
import com.ahmadrosid.lib.baseapp.core.view.BaseRecyclerView;
import com.uwacoding.app.codelabs.R;

import butterknife.BindView;

/**
 * Created by Firman on 3/29/2017.
 */

public class HomeFragment extends BaseFragment implements ViewHome{


    private static final String TAG = "HomeFragment";

    @BindView(R.id.common_list_iklan)
    BaseRecyclerView common_list_iklan;
    @BindView(R.id.loader)
    ProgressBar loader;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private HomeFragmentPresenter presenter;

    @Override
    protected int getResourceLayout(){
        return R.layout.fragment_home;
    }

    @Override
    public void setDataIklan(RecyclerView.Adapter adapter) {
        common_list_iklan.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        common_list_iklan.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        alert(message);
    }

    @Override
    public void dismishrefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void startLoading() {
        loader.setVisibility(View.VISIBLE);
        common_list_iklan.setVisibility(View.GONE);

    }

    @Override
    public void stopLoading() {
        loader.setVisibility(View.GONE);
        common_list_iklan.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        presenter= new HomeFragmentPresenter(this, getActivity());
        presenter.loadCommonIklan();
        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    private void refreshData() {
        presenter.refreshIklan();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
