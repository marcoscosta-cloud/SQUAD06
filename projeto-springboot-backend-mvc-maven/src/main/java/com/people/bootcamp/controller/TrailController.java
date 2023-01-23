package com.people.bootcamp.controller;

import java.util.List;
import java.util.Optional;

import com.people.bootcamp.controller.exceptions.NotFoundException;
import com.people.bootcamp.controller.exceptions.TrailNotFoundException;
import com.people.bootcamp.controller.exceptions.UserNotFoundException;
import com.people.bootcamp.controller.model.*;
import com.people.bootcamp.repository.model.TrailModel;
import com.people.bootcamp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.people.bootcamp.service.TrailService;
import com.people.bootcamp.service.domain.Trail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/trails", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrailController {
    @Autowired
    private TrailService trailService;
    @Autowired
    private ContentService contentService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Trail>> all() {
        log.info("getAll Trail");
        Optional<List<Trail>> trailOptional = trailService.findAll();
        if (trailOptional.isPresent()) {
            return Optional.ofNullable(GetTrailResponseMapper.INSTANCE.entityToResponse(trailOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    // Ajuste/implemente classes e métodos para "mostrar" progresso concluído de uma trilha para um usuário
    // /api/v1/trails/1?userId=2
        @GetMapping(path = "/{id}/counters")
    public ResponseEntity<GetCountersResponse> getUserCounters(@PathVariable Long id, @RequestParam(required = true) Long userId) {
        log.info("GetCountersResponse");
        GetCountersResponse response = null;
        try {
            response = trailService.getUserCounters(id, userId);
        } catch (TrailNotFoundException | UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<GetTrailResponse> getById(@PathVariable Long id) {
        log.info("getById with id: {}", id);
        Optional<Trail> trailOptional;
        try {
            trailOptional = trailService.findById(id);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (trailOptional.isPresent()) {
            GetTrailResponse resp = GetTrailResponseMapper.INSTANCE.entityToResponse(trailOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
