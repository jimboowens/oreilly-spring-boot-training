package com.oreilly.demo.json;

import java.util.List;

public class AstroResult {
    private List<Assignment> people;
    private int number;
    private String message;

    public AstroResult(){

    }

    public List<Assignment> getPeople() {
        return people;
    }

    public void setPeople(List<Assignment> people) {
        this.people = people;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
