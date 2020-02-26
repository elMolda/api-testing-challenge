package com.endava.tmdb.controllers;

import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public interface IApiController {
    RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
    String baseUrl = PropertiesHelper.getValueByKey("url.base");
    Response get();
}
