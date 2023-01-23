package com.people.bootcamp.repository;

import com.people.bootcamp.repository.model.TrailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.people.bootcamp.repository.model.ContentModel;

import java.util.List;
import java.util.Optional;


public interface ContentRepository extends JpaRepository<ContentModel, Long> {
    Optional<List<ContentModel>> findContentsByTrailsId(Long trailId);

    Optional<ContentModel> findById(Long contentId);
}
