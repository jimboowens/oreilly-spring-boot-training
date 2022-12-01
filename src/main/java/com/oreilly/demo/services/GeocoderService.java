package com.oreilly.demo.services;

import com.oreilly.demo.config.AppProperties;
import com.oreilly.demo.entity.SiteEntity;
import com.oreilly.demo.json.GeocodingResponse;
import com.oreilly.demo.json.Site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {

    @Autowired
    Logger log;

    private final AppProperties props;

    private final WebClient client;

    @Autowired
    public GeocoderService(WebClient.Builder builder,AppProperties props) {
        client = builder.baseUrl(props.getGoogleGeocodeBaseUrl()).build();
        this.props = props;
    }

    public SiteEntity updateSiteLatLng(SiteEntity site) {
        return getLatLngSiteService(site.getAddress());
    }

    public Site getLatLng(String... address) {
        String encoded = Stream.of(address)
                .map(s -> {
                    try {
                        return URLEncoder.encode(s, StandardCharsets.UTF_8.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.joining(","));

        GeocodingResponse response = client.get()
                .uri(uriBuilder -> uriBuilder.path(props.getGoogleGeocodeUri())
                        .queryParam("address", encoded)
                        .queryParam("key", props.getGoogleKey())
                        .build()
                )
                .retrieve()
                .bodyToMono(GeocodingResponse.class)
                .block(Duration.ofSeconds(2));

        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }

    public SiteEntity getLatLngSiteService(String... address) {
        String encoded = Stream.of(address)
                .map(s -> {
                    try {
                        return URLEncoder.encode(s, StandardCharsets.UTF_8.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(","));
        GeocodingResponse response = client.get()
                .uri(uriBuilder -> uriBuilder.path(props.getGoogleGeocodeUri())
                        .queryParam("address", encoded)
                        .queryParam("key", props.getGoogleKey())
                        .build()
                )
                .retrieve()
                .bodyToMono(GeocodingResponse.class)
                .block(Duration.ofSeconds(2));

        return new SiteEntity(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }
}
