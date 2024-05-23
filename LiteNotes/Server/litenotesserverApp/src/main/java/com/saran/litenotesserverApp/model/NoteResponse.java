package com.saran.litenotesserverApp.model;

import org.springframework.stereotype.Component;

@Component
public class NoteResponse {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
