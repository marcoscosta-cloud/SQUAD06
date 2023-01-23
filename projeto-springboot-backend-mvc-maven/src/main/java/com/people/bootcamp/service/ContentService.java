package com.people.bootcamp.service;


import java.util.List;
import java.util.Optional;

import com.people.bootcamp.repository.ContentRepository;
import com.people.bootcamp.repository.UserRepository;
import com.people.bootcamp.repository.model.ContentModel;
import com.people.bootcamp.repository.model.UserModel;
import com.people.bootcamp.service.domain.Content;
import com.people.bootcamp.service.domain.ContentModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.people.bootcamp.service.domain.Trail;
import com.people.bootcamp.service.domain.TrailModelMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class ContentService {

    public static final String ID_CAN_NOT_BE_NULL = "ID não pode estar vazio";

    @Autowired
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;


    public Optional<List<Content>> findAll() {
        List<ContentModel> contentModelList = contentRepository.findAll();
        List<Content> contentList = ContentModelMapper.INSTANCE.modelToEntity(contentModelList);
        return Optional.ofNullable(contentList);
    }

    public Optional<List<Content>> findContentsByTrailsId(Long trailId) {
        if (trailId == null) {
            return Optional.empty();
        }
        Optional<List<ContentModel>> optContents = contentRepository.findContentsByTrailsId(trailId);
        if (optContents.isPresent()) {
            return Optional.ofNullable(ContentModelMapper.INSTANCE.modelToEntity(optContents.get()));
        } else {
            return Optional.empty();
        }
    }

    public boolean markContent(Long idUser, Long idContent) {
        Optional<UserModel> userOptional = userRepository.findById(idUser);
        Optional<ContentModel> contentOptional = contentRepository.findById(idContent);
        if (userOptional.isPresent() && contentOptional.isPresent()) {
            if (!userOptional.get().getContents().contains(contentOptional.get())) {
                userOptional.get().getContents().add(contentOptional.get());

            }
        }
        return false;
    }

    public boolean unMarkContent(Long idUser, Long idContent) {
        Optional<UserModel> userOptional = userRepository.findById(idUser);
        Optional<ContentModel> contentOptional = contentRepository.findById(idContent);

        if (userOptional.isPresent() && contentOptional.isPresent()) {
            if (userOptional.get().getContents().contains(contentOptional.get())) {
                userOptional.get().getContents().remove(contentOptional.get());

                return true;
            }
        }

        return false;
    }
    public Optional<ContentModel> findById(Long id) {
        return contentRepository.findById(id);
    }
}




