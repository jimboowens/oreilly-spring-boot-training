package com.oreilly.demo.controllers;

import com.oreilly.demo.entity.SiteEntity;
import com.oreilly.demo.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sites")
public class SiteController {
    private final SiteService service;

    @Autowired
    public SiteController(SiteService service) {
        this.service = service;
    }

    @GetMapping
    public List<SiteEntity> findAll() {
        return service.getAllSites();
    }

    @GetMapping("{id}")
    public ResponseEntity<SiteEntity> get(@PathVariable() Integer id) {
        // re: ResponseEntity<T> typedef: A shortcut for creating a ResponseEntity with the given body and the OK
        // status, or an empty body and a NOT FOUND status in case of an Optional.empty() parameter.
        return ResponseEntity.of(service.findSiteById(id));
    }

    @PostMapping
    public ResponseEntity<SiteEntity> saveSite(@RequestParam String address) {
        SiteEntity site = service.saveSite(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(site.getId())
                .toUri();
        return ResponseEntity.created(uri).body(site);
    }

}
