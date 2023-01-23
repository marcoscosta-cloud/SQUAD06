package com.people.bootcamp.controller.model;

import com.people.bootcamp.repository.model.ContentModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetTrailResponse {

    private Long id;
    private String title;
    private String description;
    private String code;
    private String url;
    private List<ContentModel> contents;
    //private List<GetContentResponse> contents;
}
