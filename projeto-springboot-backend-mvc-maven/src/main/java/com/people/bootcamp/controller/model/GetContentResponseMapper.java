package com.people.bootcamp.controller.model;

import com.people.bootcamp.service.domain.Content;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GetContentResponseMapper {
    GetContentResponseMapper INSTANCE = Mappers.getMapper(GetContentResponseMapper.class);

    @Mapping(target = "title")
    GetContentResponse entityToResponse(Content entity);

    List<GetContentResponse> entityToResponse(List<Content> content);

}
