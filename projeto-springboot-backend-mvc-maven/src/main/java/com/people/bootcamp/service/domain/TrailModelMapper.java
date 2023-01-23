package com.people.bootcamp.service.domain;


import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.people.bootcamp.repository.model.TrailModel;

@Mapper
public interface TrailModelMapper {
	
    TrailModelMapper INSTANCE = Mappers.getMapper(TrailModelMapper.class);

    List<Trail> modelToEntity(List<TrailModel> trailModelList);

	Trail modelToEntity(TrailModel trailModel);

    TrailModel entityToModel(Trail trail);

    List<TrailModel> entityToModels(List<Trail> trailList);
	

}
