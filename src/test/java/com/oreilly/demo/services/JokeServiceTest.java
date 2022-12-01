package com.oreilly.demo.services;

import com.oreilly.demo.config.AppProperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("WeakerAccess")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JokeServiceTest {

    @Autowired
    Logger logger;

    @Autowired
    JokeService service;

    AppProperties props;

    @Test
    public void getJoke() {
        String joke = service.getJoke("Jim", "Owens");
        logger.info("joke: [" + joke + "]");
        assertTrue(joke.contains("Jim") || joke.contains("Owens"));
    }

    @Test
    public void getJokeAsync() {
        String joke = service.getJokeAsync("Jim", "Owens").block(Duration.ofSeconds(2));
        logger.info("jokeAsync: [" + joke + "]");
        assertTrue(joke.contains("Jim") || joke.contains("Owens"));
    }

    @Test
    public void useStepVerifier() {
        logger.info(props.toString());
        StepVerifier.create(service.getJokeAsync("Jim", "Owens"))
                .assertNext(joke -> {
                    logger.info("joke: [" + joke + "]");
                    assertTrue(joke.contains("Jim") || joke.contains("Owens"));
                })
                .verifyComplete();
    }
}
