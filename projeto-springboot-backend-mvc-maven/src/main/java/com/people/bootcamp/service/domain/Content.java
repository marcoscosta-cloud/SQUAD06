package com.people.bootcamp.service.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Content {

    private Long id;
    private String title;
    private String description;
    private String typeContent;
    private String urlContent;
    private String urlImage;

}
