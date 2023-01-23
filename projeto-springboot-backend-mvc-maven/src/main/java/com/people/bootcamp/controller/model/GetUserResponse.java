package com.people.bootcamp.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponse {
	private String name;
    private String userName;
}
