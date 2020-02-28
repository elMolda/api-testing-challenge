package com.endava.tmdb.controllers;

import com.endava.tmdb.builders.UrlBuilder;
import com.endava.tmdb.entities.Rate;
import com.endava.tmdb.helpers.JsonHelper;
import com.endava.tmdb.helpers.PropertiesHelper;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.net.URL;

public class RateController extends IApiController {
    private URL url;

    public RateController() {
    }

    public Response post(Rate rate, String to_rate) {
        if (to_rate.equals("movie")){
            return this.rateMovie(rate);
        } else if (to_rate.equals("tv_show")) {
            return this.rateTvShow(rate);
        } else if (to_rate.equals("tv_episode")){
            return this.rateTvEpisode(rate);
        }
        return null;
    }

    private Response rateMovie(Rate rate) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("movie.endpoint"))
                .addPathStep(rate.getMovie_id())
                .addPathStep(PropertiesHelper.getValueByKey("op.rating"))
                .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
                .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
                .addParamValue(Serenity.sessionVariableCalled("session_id"))
                .build();
        refreshRequestSpecification();
        return requestSpecification.body(JsonHelper.objectToJson(rate)).post(url);
    }

    private Response rateTvShow(Rate rate) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("tv.endpoint"))
                .addPathStep(rate.getTv_id())
                .addPathStep(PropertiesHelper.getValueByKey("op.rating"))
                .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
                .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
                .addParamValue(Serenity.sessionVariableCalled("session_id"))
                .build();
        refreshRequestSpecification();
        return requestSpecification.body(JsonHelper.objectToJson(rate)).post(url);
    }

    private Response rateTvEpisode(Rate rate) {
        url = new UrlBuilder(baseUrl)
                .addEndPoint(PropertiesHelper.getValueByKey("tv.endpoint"))
                .addPathStep(rate.getTv_id())
                .addPathStep(PropertiesHelper.getValueByKey("season"))
                .addPathStep(rate.getSeason())
                .addPathStep(PropertiesHelper.getValueByKey("episose"))
                .addPathStep(rate.getEpisode())
                .addPathStep(PropertiesHelper.getValueByKey("op.rating"))
                .addApiKey(PropertiesHelper.getValueByKey("param.api_key"))
                .addParamValue(PropertiesHelper.getValueByKey("value.api_key"))
                .addSessionId(PropertiesHelper.getValueByKey("param.session_id"))
                .addParamValue(Serenity.sessionVariableCalled("session_id"))
                .build();
        refreshRequestSpecification();
        return requestSpecification.body(JsonHelper.objectToJson(rate)).post(url);
    }
}
