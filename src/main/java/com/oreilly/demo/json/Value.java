package com.oreilly.demo.json;

import java.util.List;

public class Value {

    private String id;

    private String joke;

    private List<String> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id='" + id + '\'' +
                ", joke='" + joke + '\'' +
                ", categories=" + categories +
                '}';
    }
}
