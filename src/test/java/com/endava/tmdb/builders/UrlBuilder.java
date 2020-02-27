package com.endava.tmdb.builders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlBuilder {
    private String baseUrl;
    private List<String> path;

    public UrlBuilder(String baseUrl){
        this.baseUrl = baseUrl;
        path = new ArrayList<>();
    }

    public UrlBuilder addEndPoint(String endpoint){
        path.add(endpoint);
        return this;
    }

    public UrlBuilder addPathStep(String step){
        path.add(step);
        return this;
    }

    public UrlBuilder addApiKey(String param){
        String last = path.get(path.size()-1);
        int indexOfLast = path.indexOf(last);
        path.set(indexOfLast, last + "?" + param + "=");
        return this;
    }

    public UrlBuilder addParamValue(String value){
        String last = path.get(path.size()-1);
        int indexOfLast = path.indexOf(last);
        path.set(indexOfLast, last + value);
        return this;
    }


    public UrlBuilder addSessionId(String session_id) {
        String last = path.get(path.size()-1);
        int indexOfLast = path.indexOf(last);
        path.set(indexOfLast, last + "&" + session_id + "=");
        return this;
    }

    public URL build(){
        try {
            return new URL(baseUrl +"/"+String.join("/", path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
