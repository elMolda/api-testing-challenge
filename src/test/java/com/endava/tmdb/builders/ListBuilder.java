package com.endava.tmdb.builders;

import com.endava.tmdb.entities.List;

public class ListBuilder {
    private List list;

    public ListBuilder() { this.list = new List(); }

    public ListBuilder withListId(int listId) {
        list.setList_id(listId);
        return this;
    }

    public ListBuilder withName(String name) {
        list.setName(name);
        return this;
    }

    public ListBuilder withDescription(String description) {
        list.setDescription(description);
        return this;
    }

    public ListBuilder withLanguage(String language) {
        list.setLanguage(language);
        return this;
    }

    public List build() {
        return list;
    }


}
