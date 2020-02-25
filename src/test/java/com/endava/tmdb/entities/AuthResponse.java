package com.endava.tmdb.entities;

public class AuthResponse {
    private boolean success;
    private String expires_at;
    private String request_token;
    private String session_id;

    public AuthResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "success=" + success +
                ", expires_at='" + expires_at + '\'' +
                ", request_token='" + request_token + '\'' +
                '}';
    }
}
