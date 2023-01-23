package com.people.bootcamp.controller.exceptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormValidationException> handle(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream().map(e -> {
            String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            return new FormValidationException(e.getField(), msg);
        }).toList();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ IllegalArgumentException.class })
    public void handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("handling illegal argument exception with message: {}", ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class })
    public void handleUserNotFoundException(NotFoundException ex) {
        log.error("handling user not found exception with message: {}", ex.getMessage());
    }
}
