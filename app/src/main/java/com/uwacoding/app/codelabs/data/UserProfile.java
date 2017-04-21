package com.uwacoding.app.codelabs.data;

import com.ahmadrosid.lib.baseapp.data.PreferencesManager;

/**
 * Created by Firman on 3/29/2017.
 */

public class UserProfile {

    private static UserProfile instance;

    public String name;
    public String email;
    public String photo;
    public String accessToken;
    public boolean loginWith;

    public static UserProfile getInstance() {
        if (instance == null)
            instance = new UserProfile();
        return instance;
    }

    public static final void login(String data) {
        PreferencesManager.saveString(CodelabsConstants.LOGIN_CACHE, data);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isLoginWith() {
        return loginWith;
    }

    public void setLoginWith(boolean loginWith) {
        this.loginWith = loginWith;
    }
}
