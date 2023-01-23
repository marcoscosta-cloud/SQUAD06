package com.people.bootcamp.controller.exceptions;

public class TrailNotFoundException extends Exception {

	public TrailNotFoundException(Long id) {
		super("Não foi possível achar a Trilha  com id: " + id);
	}
}
