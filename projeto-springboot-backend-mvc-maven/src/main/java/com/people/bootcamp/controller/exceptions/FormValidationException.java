package com.people.bootcamp.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormValidationException {
    private String campo;
    private String erro;
}
