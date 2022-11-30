package com.oreilly.demo.dao;

import com.oreilly.demo.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<SiteEntity, Integer> {
}
