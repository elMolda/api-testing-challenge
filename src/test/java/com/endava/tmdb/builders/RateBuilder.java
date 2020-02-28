package com.endava.tmdb.builders;

import com.endava.tmdb.entities.Rate;

public class RateBuilder {

    private Rate rate;

    public RateBuilder() {
        this.rate = new Rate();
    }

    public RateBuilder withValue(double value) {
        this.rate.setValue(value);
        return this;
    }

    public RateBuilder withMovieId(String movieId) {
        this.rate.setMovie_id(movieId);
        return this;
    }

    public RateBuilder withTvId(String tvId) {
        this.rate.setTv_id(tvId);
        return this;
    }

    public RateBuilder withEpisode(String episode) {
        this.rate.setEpisode(episode);
        return this;
    }

    public RateBuilder withSeason(String season) {
        this.rate.setSeason(season);
        return this;
    }

    public Rate build() {
        return this.rate;
    }
}
