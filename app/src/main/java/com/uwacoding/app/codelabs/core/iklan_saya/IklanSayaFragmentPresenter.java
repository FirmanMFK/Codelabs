package com.uwacoding.app.codelabs.core.iklan_saya;

import android.content.Intent;
import android.util.Log;

import com.ahmadrosid.lib.baseapp.core.BasePresenter;
import com.ahmadrosid.lib.baseapp.helper.BaseRecyclerAdapter;
import com.uwacoding.app.codelabs.R;
import com.uwacoding.app.codelabs.api.Endpoint;
import com.uwacoding.app.codelabs.core.detail.DetailIklanActivity;
import com.uwacoding.app.codelabs.core.home.IklanModel;
import com.uwacoding.app.codelabs.core.home.ItemIklanHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.uwacoding.app.codelabs.api.CodelabsAPI.getIklanSaya;

/**
 * Created by Firman on 3/29/2017.
 */

public class IklanSayaFragmentPresenter extends BasePresenter<IklanSayaView> {

    private static final String TAG = "IklanSayaFragmentPresen";

    List<IklanModel> data = new ArrayList<>();

    public IklanSayaFragmentPresenter(IklanSayaView mvpView) {
        super(mvpView);
    }

    public void loadIklanSaya() {
        getMvpView().startLoading();
        getSubscraiber().add(
                getIklanSaya()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onResponse, this::onError)
        );

        Log.d(TAG, "loadIklanSaya: " + Endpoint.IKLAN);
    }

    private void onResponse(String json) {
        Log.d(TAG, "onResponses: " + json);
        getMvpView().stopLoading();
        parseData(json);
    }

    private void parseData(String json) {
        data.clear();
        JSONObject jobject = null;
        try {
            jobject = new JSONObject(json);
            if (jobject.names().length() == 0) {
                getMvpView().showMessage("Belum ada Iklan.");
            } else {
                for (int i = 0; i < jobject.names().length(); i++) {
                    String value = jobject.get(jobject.names().getString(i)).toString();
                    IklanModel iklanData = getParser().fromJson(value, IklanModel.class);
                    data.add(iklanData);
                    setAdapter();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setAdapter() {
        BaseRecyclerAdapter<IklanModel, ItemIklanHolder> adapter =
                new BaseRecyclerAdapter<IklanModel, ItemIklanHolder>(
                        data, IklanModel.class,
                        R.layout.item_list_iklan, ItemIklanHolder.class) {
                   @Override protected void bindView(ItemIklanHolder holder, IklanModel model, int position) {
                       holder.bindView(model);
                       holder.itemView.setOnClickListener(view -> {
                           Intent intent = new Intent(view.getContext(), DetailIklanActivity.class);
                            view.getContext().startActivity(intent);
                       });
                   }
                };
                getMvpView().setDataIklan(adapter);
    }

    private void onError(Throwable throwable){
        Log.e(TAG, "onError: ", throwable);
        getMvpView().stopLoading();
        getMvpView().showMessage("Failed load data");
    }

    public void refreshIklan() {
        getSubscraiber().add(
                getIklanSaya()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onResponseRefresh, this::onError)
        );
    }

    private void onResponseRefresh(String json) {
        parseData(json);
        getMvpView().dismishrefresh();
    }

}

