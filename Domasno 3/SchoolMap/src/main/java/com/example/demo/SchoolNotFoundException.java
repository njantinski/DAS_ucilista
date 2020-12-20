package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException(Long id){
        super(String.format("School with id %d is not found!",id));
    }
}
