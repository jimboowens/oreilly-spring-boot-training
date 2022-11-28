package com.oreilly.demo.services;

import com.oreilly.demo.json.GeocodingResponse;
import com.oreilly.demo.json.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.net.URLEncoder.encode;

@Service
public class GeocoderService {

    @Autowired
    Logger log;
    private static final String baseUrl = "https://maps.googleapis.com";

    private static final String geocodeURI = "/maps/api/geocode/json";

    @Value("${google.key}")
    private String KEY;
    private final WebClient client;

    @Autowired
    public GeocoderService(WebClient.Builder builder) {
        client = builder.baseUrl(baseUrl).build();
    }

    public Site getLatLng(String... address) {
        String encoded = Stream.of(address)
                .map(s -> {
                    try {
                        return URLEncoder.encode(s, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(","));
        log.info("here, key: [" + KEY +"]");

        GeocodingResponse response = client.get()
                .uri(uriBuilder -> uriBuilder.path(geocodeURI)
                        .queryParam("address", encoded)
                        .queryParam("key", KEY)
                        .build()
                )
                .retrieve()
                .bodyToMono(GeocodingResponse.class)
                .block(Duration.ofSeconds(2));

        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }
}
