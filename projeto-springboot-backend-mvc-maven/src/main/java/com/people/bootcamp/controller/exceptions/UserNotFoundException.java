package com.people.bootcamp.controller.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("Não foi possível achar o Usuário com id: " + id);
    }
}
