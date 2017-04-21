package com.uwacoding.app.codelabs.api;

import com.ahmadrosid.lib.baseapp.api.BaseApi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import rx.Observable;

/**
 * Created by Firman on 3/29/2017.
 */

public class CodelabsAPI {

    private static final OkHttpClient client = new OkHttpClient();

    public static Observable<String> getIklan() {
        Request request = new Request.Builder()
                .url(Endpoint.IKLAN)
                .get()
                .build();
        return BaseApi.streamLines(client, request);
    }
    public static Observable<String> getIklanSaya() {
        Request request = new Request.Builder()
                .url(Endpoint.IKLAN_SAYA)
                .get()
                .build();
        return BaseApi.streamLines(client, request);
    }
}
