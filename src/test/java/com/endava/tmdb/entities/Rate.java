package com.endava.tmdb.entities;


public class Rate {
    private String movie_id;
    private int value;

    public Rate() {
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "movie_id='" + movie_id + '\'' +
                ", value=" + value +
                '}';
    }
}
