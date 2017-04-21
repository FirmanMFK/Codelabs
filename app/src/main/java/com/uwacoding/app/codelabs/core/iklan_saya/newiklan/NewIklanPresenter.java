package com.uwacoding.app.codelabs.core.iklan_saya.newiklan;

import com.ahmadrosid.lib.baseapp.core.BasePresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Firman on 3/29/2017.
 */

public class NewIklanPresenter extends BasePresenter<NewIklanView> {

    private DatabaseReference mDatabase;

    public NewIklanPresenter(NewIklanView mvpView) {
        super(mvpView);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void postNewIklan(String judul, String harga, String lokasi, String description, String url_photo) {
        getMvpView().startLoading();
        PostNewIklan postNewIklan = new PostNewIklan(getUid(), judul, harga, lokasi, description, url_photo);
        String key = mDatabase.child("iklan").push().getKey();
        Map<String, Object> postValues = postNewIklan.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/iklan/" + key, postValues);
        childUpdates.put("/users/iklan/" + getUid() + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates)
                .addOnCompleteListener(getMvpView().getActivity(), task -> {
                    if (task.isComplete()) {
                        getMvpView().stopLoading();
                        getMvpView().finishAddNewIklan();
                    }
                });

    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
