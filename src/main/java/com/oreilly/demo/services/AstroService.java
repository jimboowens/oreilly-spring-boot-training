package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;


@Service
public class AstroService {
    private final String baseUrl = "http://api.open-notify.org/";
    private final String astrosURI = "/astros.json";
    private final RestTemplate template;
    private final WebClient client;

    // doesn't actually have to be autowired for the RestTemplateBuilder to be plugged in here, but good for
    // documentation/usability
    @Autowired
    public AstroService(RestTemplateBuilder rtBuilder,WebClient.Builder wcBuilder) {
        template = rtBuilder.build();
        client = wcBuilder.baseUrl(baseUrl).build();
    }

    public AstroResult getAstronautsRT() {
        String url = baseUrl + astrosURI;
        return template.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWC() {
        // client is async, but the block makes the promise just within this method. return null if more than 2 seconds.
        return client.get()
                .uri(astrosURI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}
