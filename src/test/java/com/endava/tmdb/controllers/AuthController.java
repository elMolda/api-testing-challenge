package com.endava.tmdb.controllers;

import com.endava.tmdb.builders.UrlBuilder;
import com.endava.tmdb.entities.AuthResponse;
import com.endava.tmdb.helpers.JsonHelper;
import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.response.Response;

import java.net.URL;

public class AuthController implements IApiController{
    private URL url;
    public AuthController() {
    }

    public Response get(){ return  null; }

    public Response getWithParam(String param, String operation)
    {
        if (operation.equals("reqToken")) {
            return this.getRequestToken(param);
        }else if (operation.equals("guest")) {
            return this.getGuestSession(param);
        }
        return null;
    }


    private Response getGuestSession(String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("guest_session"))
                .addPathStep(PropertiesHelper.getValueByKey("new"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        return requestSpecification.when().get(url);
    }

    private Response getRequestToken(String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("token"))
                .addPathStep(PropertiesHelper.getValueByKey("new"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        return requestSpecification.when().get(url);
    }

    public Response post(String operation, AuthResponse authResponse, String api_key) {
        if (operation.equals("ask")) {
            return this.askPermission(authResponse,api_key);
        }else if (operation.equals("generate")) {
            return this.generateSessionId(authResponse, api_key);
        }
        return null;
    }

    private Response askPermission(AuthResponse authResponse, String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("token"))
                .addPathStep(PropertiesHelper.getValueByKey("validate"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        return requestSpecification.when().body(JsonHelper.objectToJson(authResponse)).and().post(url);
    }

    private Response generateSessionId(AuthResponse authResponse, String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("session"))
                .addPathStep(PropertiesHelper.getValueByKey("new"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        return requestSpecification.when().body(JsonHelper.objectToJson(authResponse)).and().post(url);
    }

    public Response delete(AuthResponse authResponse, String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("session"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        return requestSpecification.body(JsonHelper.objectToJson(authResponse)).delete(url);
    }
}
