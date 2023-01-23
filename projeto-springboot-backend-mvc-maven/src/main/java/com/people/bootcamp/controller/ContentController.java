package com.people.bootcamp.controller;

import java.util.List;
import java.util.Optional;

import com.people.bootcamp.controller.model.GetContentResponse;
import com.people.bootcamp.controller.model.GetContentResponseMapper;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.ContentService;
import com.people.bootcamp.service.UserService;

import com.people.bootcamp.service.domain.Content;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/contents", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @GetMapping("/trails/{trailId}")
    public ResponseEntity<List<GetContentResponse>> findContentsByTrailsId(@PathVariable Long trailId) {
        log.info("findContentsByTrailsId with id: {}", trailId);

        Optional<List<Content>> contents = contentService.findContentsByTrailsId(trailId);
        if (contents.isPresent()) {
            List<GetContentResponse> response = GetContentResponseMapper.INSTANCE.entityToResponse(contents.get());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PutMapping(path = "/{id}") // /contents/{id}?userId=1&marcar=true
    public ResponseEntity<String> putById(@PathVariable Long id, @RequestParam Long userId, @RequestParam Boolean marcar) {
        log.info("getById with id: {}", id);

        Optional<ContentModel> contentModel = contentService.findById(id);
        Optional<UserModel> userModel = userService.findById(userId);

        if (contentModel.isEmpty() || userModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conteúdo ou usuário nao encontrado.");
        }

        if (marcar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi informado se é para marcar ou desmarcar o conteúdo.");
        }

        if (marcar) {
            if (contentService.markContent(userId, id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Conteúdo marcado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Conteúdo já estava marcado.");
            }
        } else {
            if (contentService.unMarkContent(userId, id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Conteúdo desmarcado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Conteúdo não estava marcado para o usuário.");
            }
        }


    }
}