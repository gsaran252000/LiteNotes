package com.saran.litenotesserverApp.model;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {
    private String authtoken;
    private boolean status;

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserResponse(){
    }
}
