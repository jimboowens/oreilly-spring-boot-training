package com.oreilly.demo.controllers;

import com.oreilly.demo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {
    // could be declared, but also can be supplied (in JUnit 5) as an @Autowired argument
    // NOTE: the random port is known by the TestRestTemplate by default.
    // @Autowired
    // private TestRestTemplate template;

    @Test
    public void testRestHelloWithName(@Autowired TestRestTemplate template) throws Exception {
        Greeting response = (Greeting) template.getForObject("/restHello?name=Jim", Greeting.class);
        assertEquals("Hello, Jim!", response.message());
    }

    @Test
    public void testRestHelloWithoutName(@Autowired TestRestTemplate template) throws Exception {
        // entity is overloaded, not a class mapping to a db table, but a response entity from a URL get
        ResponseEntity<Greeting> entity = template.getForEntity("/restHello", Greeting.class);
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        Greeting response = entity.getBody();

        if (response != null) {
            assertEquals("Hello, World!", response.message());
        }
    }
}
