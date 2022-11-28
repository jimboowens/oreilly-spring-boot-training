package com.oreilly.demo.services;

import com.oreilly.demo.json.Site;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GeocoderServiceTest {
    @Autowired
    private Logger log;

    @Autowired
    private GeocoderService service;

    @Test
    public void getLatLngWithoutStreet() {
        Site site = service.getLatLng("Boston", "MA");
        log.info("site: [" + site + "]");
        assertAll(
                () -> assertEquals(42.36, site.getLatitude(), 0.01),
                () -> assertEquals(-71.06, site.getLongitude(), 0.01)
        );

    }

    @Test
    public void getLatLngWithStreet() {
        Site googleHQ = service.getLatLng("1600 Amphitheater Parkway", "Mountain View", "CA");
        log.info("googleHQ: [" + googleHQ + "]");
        assertAll(
                () -> assertEquals(37.42, googleHQ.getLatitude(), 0.01),
                () -> assertEquals(-122.08, googleHQ.getLongitude(), 0.01)
        );
    }
}
