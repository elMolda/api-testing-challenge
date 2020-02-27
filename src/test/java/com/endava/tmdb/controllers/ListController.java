package com.endava.tmdb.controllers;

import com.endava.tmdb.builders.UrlBuilder;
import com.endava.tmdb.entities.List;
import com.endava.tmdb.helpers.JsonHelper;
import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.yecht.Data;

import java.net.URL;

public class ListController extends IApiController{

    private URL url;

    public Response get() { return null; }

    public Response get(int list_id) {
        return this.getList(list_id);
    }

    public Response post(List list, String operation) {
        if (operation.equals("create")){
            return this.createList(list);
        } else if (operation.equals("add_item")) {
            return this.addItemToList(list);
        }
        return null;
    }

    private Response addItemToList(List list) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("list.endpoint"))
                .addPathStep(String.valueOf(list.getList_id()))
                .addPathStep(PropertiesHelper.getValueByKey("op.add_item"))
                .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
                .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
                .addParamValue(Serenity.sessionVariableCalled("session_id"))
                .build();
        String json = JsonHelper.objectToJson(list);
        refreshRequestSpecification();
        return requestSpecification.body(json).post(url);
    }

    private Response getList(int list_id) {
        url = new UrlBuilder(baseUrl)
            .addEndPoint(PropertiesHelper.getValueByKey("list.endpoint"))
            .addPathStep(String.valueOf(list_id))
            .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
            .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
            .addLanguage(PropertiesHelper.getValueByKey("lang.en"))
            .build();
        refreshRequestSpecification();
        return requestSpecification.get(url);
    }


    private Response createList(List list) {
        url = new UrlBuilder(baseUrl)
            .addEndPoint(PropertiesHelper.getValueByKey("list.endpoint"))
            .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
            .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
            .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
            .addParamValue(Serenity.sessionVariableCalled("session_id"))
            .build();
        refreshRequestSpecification();
        return requestSpecification.body(JsonHelper.objectToJson(list)).post(url);
    }

}
