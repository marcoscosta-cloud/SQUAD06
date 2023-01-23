package com.people.bootcamp.controller;

import com.people.bootcamp.controller.exceptions.NotFoundException;
import com.people.bootcamp.controller.model.GetUserResponse;
import com.people.bootcamp.controller.model.GetUserResponseMapper;
import com.people.bootcamp.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@Component
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getByName(@RequestParam String name) {
        log.info("getByName with name: {}", name);
        return GetUserResponseMapper.INSTANCE.entityToResponse(service.findByName(name).orElseThrow(NotFoundException::new));
    }
}