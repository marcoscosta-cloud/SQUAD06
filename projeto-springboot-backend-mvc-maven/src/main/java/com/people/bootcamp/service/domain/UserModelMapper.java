package com.people.bootcamp.service.domain;

import com.people.bootcamp.repository.model.UserModel;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);
    User modelToEntity(UserModel model);
}
