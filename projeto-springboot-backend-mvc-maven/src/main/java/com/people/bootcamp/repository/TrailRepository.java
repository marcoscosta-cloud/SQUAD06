package com.people.bootcamp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.people.bootcamp.repository.model.TrailModel;

import java.util.Optional;

public interface TrailRepository extends JpaRepository<TrailModel, Long> {

    Optional<TrailModel> findById(Long trailId);
}
