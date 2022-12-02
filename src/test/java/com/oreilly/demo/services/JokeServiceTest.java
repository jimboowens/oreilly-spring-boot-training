package com.oreilly.demo.services;

import com.oreilly.demo.config.AppProperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.time.Duration;
//import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("WeakerAccess")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JokeServiceTest {

//   @Autowired
//   Logger logger;

    @Autowired
    JokeService service;

    private String replacement;

    @Autowired
    public JokeServiceTest(AppProperties props){
        replacement = props.getJokeNameReplacement();
    }

    @Test
    public void getJoke() {
        String joke = service.getJoke(replacement);
        assertTrue(joke.contains(replacement));
    }

    @Test
    public void getJokeAsync() {
        String joke = service.getJokeAsync(replacement).block(Duration.ofSeconds(2));
        assertTrue(joke.contains(replacement));
    }

    @Test
    public void useStepVerifier() {
        StepVerifier.create(service.getJokeAsync(replacement))
                .assertNext(joke -> assertTrue(joke.contains(replacement)))
                .verifyComplete();
    }
}
