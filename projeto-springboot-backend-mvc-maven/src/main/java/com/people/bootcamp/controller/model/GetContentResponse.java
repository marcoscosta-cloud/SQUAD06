package com.people.bootcamp.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class GetContentResponse {

    private Long id;
    private String title;
    private String description;
    private String typeContent;
    private String urlContent;
    private String urlImage;

}
