package com.oreilly.demo.json;

import java.util.List;

public class JokeResponse {
    
    private String id;

    private List<String> categories;

    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "id='" + id + '\'' +
                ", categories=" + categories +
                ", value='" + value + '\'' +
                '}';
    }
}
