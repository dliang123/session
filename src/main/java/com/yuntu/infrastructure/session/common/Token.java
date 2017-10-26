package com.yuntu.infrastructure.session.common;

import javax.validation.constraints.NotNull;

/**
 * user access token
 * @author jackdeng
 * Created by jackdeng on 2017/10/26.
 */
public class Token {
    private String userID;

    @NotNull
    private String token;

    private String expiredTime;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
}
