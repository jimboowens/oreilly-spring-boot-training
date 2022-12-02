package com.oreilly.demo.services;

import com.oreilly.demo.json.JokeResponse;
import com.oreilly.demo.config.AppProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
// import java.util.logging.Logger;

@Service
public class JokeService {

    // @Autowired
    // private Logger log;

    private final RestTemplate template;

    private final WebClient client;

    private final AppProperties props;

    @Autowired
    public JokeService(RestTemplateBuilder builder, ApplicationContext context, AppProperties props) {
        this.template = builder.build();
        // allow us to have more than one concurrent WebClient
        this.client = context.getBean("jokeWebClient", WebClient.class);
        this.props = props;
    }

    private String getUriForFirstAndLastName(String base, String name) {
        return String.format(base + "&name=%s", name);
    }

    public String getJoke(String name) {
        String url = getUriForFirstAndLastName(props.getJokeUrlFull(), name);
        JokeResponse response = template.getForObject(url, JokeResponse.class);
        return response != null
                ? response.getValue()
                : "";
    }

    public Mono<String> getJokeAsync(String name) {
        String path = getUriForFirstAndLastName(props.getJokeUri(), name);

        return client.get()
                .uri(path)
                .retrieve()
                .bodyToMono(JokeResponse.class)
                .map(jokeResponse -> jokeResponse.getValue());
    }


}
