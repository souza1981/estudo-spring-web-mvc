package br.com.souza1981.springwebmvc.rest;

import br.com.souza1981.springwebmvc.exception.JediNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JediNotFoundException.class)
    public void jediNotFound(){

    }

}
