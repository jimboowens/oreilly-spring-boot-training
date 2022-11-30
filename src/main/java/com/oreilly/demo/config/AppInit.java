package com.oreilly.demo.config;

import com.oreilly.demo.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {
    private final SiteService service;

    @Autowired
    public AppInit(SiteService siteService) {
        this.service = siteService;
    }

    @Override
    public void run(String... args) {
        service.initializeDatabase();
    }

}
