package com.people.bootcamp.controller.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.people.bootcamp.service.domain.User;

@Mapper
public interface GetUserResponseMapper {
    GetUserResponseMapper INSTANCE = Mappers.getMapper(GetUserResponseMapper.class);

    @Mapping(source = "login", target = "userName")
    GetUserResponse entityToResponse(User entity);
}