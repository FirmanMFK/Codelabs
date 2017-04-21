package com.uwacoding.app.codelabs.api;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Firman on 3/29/2017.
 */

public class Endpoint {
    private static String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    public static final String MAIN_URL = "https://artist-a2338.firebaseio.com/";
    private static final String AUTH = "?auth=l2YG9CCv6CQJ1AuicU2D81GL87IS39F6aPcDoimx";
    public static final String IKLAN = MAIN_URL + "iklan.json" + AUTH;
    public static final String IKLAN_SAYA = MAIN_URL + "users/iklan/" + uid + ".json" + AUTH;
}
