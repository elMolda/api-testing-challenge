package com.endava.tmdb.controllers;

import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class IApiController {
    protected RequestSpecification requestSpecification;
    protected String baseUrl = PropertiesHelper.getValueByKey("url.base");
    protected void refreshRequestSpecification() {
     requestSpecification = null;
     requestSpecification = RestAssured.given().contentType(ContentType.JSON);
    }
}
