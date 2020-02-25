package com.endava.tmdb.builders;

import com.endava.tmdb.entities.AuthResponse;
import org.yecht.Data;

public class AuthResponseBuilder {
    private AuthResponse authResponse;

    public AuthResponseBuilder() { authResponse = new AuthResponse(); }

    public AuthResponseBuilder(AuthResponse authResponse) { this.authResponse = authResponse; }

    public AuthResponseBuilder withSuccess(boolean success) {
        authResponse.setSuccess(success);
        return this;
    }

    public AuthResponseBuilder withRequestToken(String requestToken) {
        authResponse.setRequest_token(requestToken);
        return this;
    }

    public AuthResponseBuilder withSessionId(String sessionId) {
        authResponse.setSession_id(sessionId);
        return this;
    }

    public AuthResponseBuilder withExpiresAt(String expiresAt) {
        authResponse.setExpires_at(expiresAt);
        return this;
    }

    public AuthResponse build() { return this.authResponse; }

}
