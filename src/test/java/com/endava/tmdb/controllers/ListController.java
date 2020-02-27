package com.endava.tmdb.controllers;

import com.endava.tmdb.builders.UrlBuilder;
import com.endava.tmdb.entities.List;
import com.endava.tmdb.helpers.JsonHelper;
import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.net.URL;

public class ListController implements IApiController{

    private URL url;

    public Response get() { return null; }

    public Response post(List list, String operation) {
        if (operation.equals("create")){
            return this.createList(list);
        }
        return null;
    }

    private Response createList(List list) {
        url = new UrlBuilder(baseUrl)
            .addEndPoint(PropertiesHelper.getValueByKey("list.endpoint"))
            .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
            .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
            .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
            .addParamValue(Serenity.sessionVariableCalled("session_id"))
            .build();
        System.out.println(url.toString());
        return requestSpecification.body(JsonHelper.objectToJson(list)).post(url);
    }
}
