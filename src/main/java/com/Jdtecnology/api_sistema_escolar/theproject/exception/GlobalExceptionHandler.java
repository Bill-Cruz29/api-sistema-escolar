package com.Jdtecnology.api_sistema_escolar.theproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> handleNotFound(NoResourceFoundException ex) {
        Map<String, Object> erroPersonalizado = new HashMap<>();
        
        erroPersonalizado.put("status", 404);
        erroPersonalizado.put("erro", "Caminho Incorreto");
        erroPersonalizado.put("mensagem", "Ups! A rota que digitou não existe no sistema escolar. Verifique a grafia.");
        
        return new ResponseEntity<>(erroPersonalizado, HttpStatus.NOT_FOUND);
    }
}