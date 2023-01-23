package com.people.bootcamp.service.domain;

import java.util.List;


import com.people.bootcamp.repository.model.ContentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.people.bootcamp.repository.model.TrailModel;

@Mapper
public interface ContentModelMapper {

    ContentModelMapper INSTANCE = Mappers.getMapper(ContentModelMapper.class);

    List<Content> modelToEntity(List<ContentModel> contentModelList);

    Content modelToEntity(ContentModel contentModel);

    ContentModel entityToModel(Content content);
}