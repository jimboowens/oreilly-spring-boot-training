package com.oreilly.demo.json;

public class JokeResponse {
    private String status;
    private Value value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "status='" + status + '\'' +
                ", value=" + value +
                '}';
    }
}
