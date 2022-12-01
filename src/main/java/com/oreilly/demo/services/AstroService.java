package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResult;
import com.oreilly.demo.config.AppProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {

    private final AppProperties props;

    private final RestTemplate template;

    private final WebClient client;

    // doesn't actually have to be autowired for the RestTemplateBuilder to be
    // plugged in here, but good for documentation/usability
    @Autowired
    public AstroService(RestTemplateBuilder rtBuilder, WebClient.Builder wcBuilder, AppProperties props) {
        template = rtBuilder.build();
        this.props = props;
        client = wcBuilder.baseUrl(props.getAstroBaseUrl()).build();
    }

    public AstroResult getAstronautsRT() {
        return template.getForObject(props.getAstroUrlFull(), AstroResult.class);
    }

    public AstroResult getAstronautsWC() {
        // client is async, but the block makes the promise just within this method.
        // return null if more than 2 seconds.
        return client.get()
                .uri(props.getAstroUri())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}
