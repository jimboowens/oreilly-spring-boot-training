package com.oreilly.demo.json;


import org.springframework.stereotype.Component;

// record allowed testing with new springframework/JUnit/JDK without being a component
// public record Greeting(String message) {
@Component
public class Greeting {

    // doesn't have to be static, but whatevs
    private static String message;

    // claims never used, but is used in test as Greeting.class
    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // for testing backward functionality when Greeting was a record
    public String message() {
        return message;
    }

    // for testing
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting {" + // -
                "message='" + message + "'" + // -
                "}";
    }
}
