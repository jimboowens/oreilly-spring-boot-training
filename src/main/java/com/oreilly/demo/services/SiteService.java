package com.oreilly.demo.services;

import com.oreilly.demo.dao.SiteRepository;
import com.oreilly.demo.entity.SiteEntity;
import com.oreilly.demo.config.AppProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class SiteService {

    private SiteRepository repository;

    private GeocoderService geocoderService;

    @Autowired
    Logger log;

    @Autowired
    public SiteService(SiteRepository repository, GeocoderService geocoderService) {
        this.repository = repository;
        this.geocoderService = geocoderService;
    }

    private SiteEntity fillInLatLng(SiteEntity siteEntity) {
        return geocoderService.updateSiteLatLng(siteEntity);
    }

    public void initializeDatabase() {
        repository.saveAll(
                List.of(
                        fillInLatLng(new SiteEntity("Boston, MA")),
                        fillInLatLng(new SiteEntity("Framingham, MA")),
                        fillInLatLng(new SiteEntity("Chattanooga, TN")),
                        fillInLatLng(new SiteEntity("Atlanta, GA"))
                )
        ).forEach(site -> log.info("site: [" + site + "]"));
    }

    public List<SiteEntity> getAllSites() {
        return repository.findAll();
    }

    public Optional<SiteEntity> findSiteById(Integer id) {
        return repository.findById(id);
    }

    public SiteEntity saveSite(String address) {
        return repository.save(new SiteEntity(address));
    }
}
