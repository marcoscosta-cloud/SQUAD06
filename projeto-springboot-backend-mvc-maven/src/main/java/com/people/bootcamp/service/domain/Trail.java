package com.people.bootcamp.service.domain;

import com.people.bootcamp.repository.model.ContentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Trail {
	
	private Long id;
	private String title;
	private String description;
	private String code;
	private String url;
	private List<Content> contents;
	
}
