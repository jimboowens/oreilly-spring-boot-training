package com.oreilly.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app.properties")
@Configuration("AppProperties")
public class AppProperties {

    private String JOKE_BASE_URL;
    private String JOKE_URI;
    private String JOKE_NAME_REPLACEMENT;

    private String GOOGLE_KEY;
    private String GOOGLE_GEOCODE_BASE_URL;
    private String GOOGLE_GEOCODE_URI;

    private String ASTRO_BASE_URL;
    private String ASTRO_URI;

    public String getJokeBaseUrl() {
        return JOKE_BASE_URL;
    }

    public void setJokeBaseUrl(String JOKE_BASE_URL) {
        this.JOKE_BASE_URL = JOKE_BASE_URL;
    }

    public String getJokeUri() {
        return JOKE_URI;
    }

    public void setJokeUri(String JOKE_URI) {
        this.JOKE_URI = JOKE_URI;
    }

    public String getJokeNameReplacement() {
        return JOKE_NAME_REPLACEMENT;
    }

    public void setJokeNameReplacement(String JOKE_NAME_REPLACEMENT) {
        this.JOKE_NAME_REPLACEMENT = JOKE_NAME_REPLACEMENT;
    }

    public String getJokeUrlFull() {
        return JOKE_BASE_URL + JOKE_URI;
    }

    public String getGoogleKey() {
        return GOOGLE_KEY;
    }

    public void setGoogleKey(String GOOGLE_KEY) {
        this.GOOGLE_KEY = GOOGLE_KEY;
    }

    public String getGoogleGeocodeBaseUrl() {
        return GOOGLE_GEOCODE_BASE_URL;
    }

    public void setGoogleGeocodeBaseUrl(String GOOGLE_GEOCODE_BASE_URL) {
        this.GOOGLE_GEOCODE_BASE_URL = GOOGLE_GEOCODE_BASE_URL;
    }

    public String getGoogleGeocodeUri() {
        return GOOGLE_GEOCODE_URI;
    }

    public void setGoogleGeocodeUri(String GOOGLE_GEOCODE_URI) {
        this.GOOGLE_GEOCODE_URI = GOOGLE_GEOCODE_URI;
    }

    public String getAstroBaseUrl() {
        return ASTRO_BASE_URL;
    }

    public void setAstroBaseUrl(String ASTRO_BASE_URL) {
        this.ASTRO_BASE_URL = ASTRO_BASE_URL;
    }

    public String getAstroUri() {
        return ASTRO_URI;
    }

    public void setAstroUri(String ASTRO_URI) {
        this.ASTRO_URI = ASTRO_URI;
    }

    public String getAstroUrlFull() {
        return ASTRO_BASE_URL + ASTRO_URI;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "JOKE_BASE_URL='" + JOKE_BASE_URL + '\'' +
                ", JOKE_URI='" + JOKE_URI + '\'' +
                ", JOKE_NAME_REPLACEMENT='" + JOKE_NAME_REPLACEMENT + '\'' +
                ", GOOGLE_KEY='" + GOOGLE_KEY + '\'' +
                ", GOOGLE_GEOCODE_BASE_URL='" + GOOGLE_GEOCODE_BASE_URL + '\'' +
                ", GOOGLE_GEOCODE_URI='" + GOOGLE_GEOCODE_URI + '\'' +
                ", ASTRO_BASE_URL='" + ASTRO_BASE_URL + '\'' +
                ", ASTRO_URI='" + ASTRO_URI + '\'' +
                '}';
    }
}