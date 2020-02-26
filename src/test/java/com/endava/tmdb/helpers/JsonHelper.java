package com.endava.tmdb.helpers;

import com.endava.tmdb.entities.AuthResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
public class JsonHelper {

    protected static Gson gson = new GsonBuilder().create();

    public static String objectToJson(Object object) {
        return gson.toJson(object, object.getClass());
    }

    public static AuthResponse authResponseBodyToObject(Response response) {
        return gson.fromJson(response.body().print(), AuthResponse.class);
    }
}
