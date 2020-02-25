package com.endava.tmdb.controllers;

import com.endava.tmdb.builders.UrlBuilder;
import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.response.Response;

import java.net.URL;

public class AuthController implements IApiController{
    private Response response;
    private URL url;
    public AuthController() {
    }

    public Response getResponse() {
        return response;
    }

    public Response get(){ return  null; }

    public Response getWithParam(String param) {
        return this.getRequestToken(param);
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getRequestToken(String api_key) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("auth.endpoint"))
                .addPathStep(PropertiesHelper.getValueByKey("token"))
                .addPathStep(PropertiesHelper.getValueByKey("new"))
                .addParamKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(api_key)
                .build();
        this.response = requestSpecification.when().get(url);
        return response;
    }

    public Response post(String operation) {
        if (operation.equals("ask")) {
            this.response = this.askPermission();
        }else if (operation.equals("generate")) {
            this.response = this.generateSessionId();
        }
        return this.response;
    }

    private Response askPermission() {
        return this.response;
    }

    private Response generateSessionId() {
        return this.response;
    }
}
