package com.people.bootcamp.controller.model;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.people.bootcamp.service.domain.Trail;

@Mapper
public interface GetTrailResponseMapper {
    GetTrailResponseMapper INSTANCE = Mappers.getMapper(GetTrailResponseMapper.class);
    GetTrailResponse entityToResponse(Trail entity);

    List<Trail> entityToResponse(List<Trail> list);
}
