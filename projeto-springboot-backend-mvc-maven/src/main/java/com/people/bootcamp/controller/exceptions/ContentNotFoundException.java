package com.people.bootcamp.controller.exceptions;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(Long id) {
        super("Não foi possível achar o conteúdo com id: " + id);
    }
}
