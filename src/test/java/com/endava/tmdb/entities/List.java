package com.endava.tmdb.entities;

public class List {
    private String name;
    private String description;
    private String language;
    private String created_by;
    private int favorite_count;
    private int list_id;
    private int item_count;
    private int status_code;
    private int media_id;

    public List() {
    }

    public int getMedia_id() {
        return media_id;
    }

    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    @Override
    public String toString() {
        return "List{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", created_by='" + created_by + '\'' +
                ", favorite_count=" + favorite_count +
                ", list_id=" + list_id +
                ", item_count=" + item_count +
                ", status_code=" + status_code +
                ", media_id=" + media_id +
                '}';
    }
}
