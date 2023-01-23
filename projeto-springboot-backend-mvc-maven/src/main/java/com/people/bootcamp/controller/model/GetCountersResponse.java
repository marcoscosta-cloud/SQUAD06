package com.people.bootcamp.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCountersResponse {

    private Long userId;

    private Long trailId;

    private Long concludedContents;

    private Long totalContents;

    private Double userTrailPercent;
}
