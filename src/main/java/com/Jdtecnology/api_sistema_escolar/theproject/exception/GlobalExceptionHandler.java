package com.Jdtecnology.api_sistema_escolar.theproject.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // --- 1. ERRO 404 (Rota Incorreta) ---
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> handleNotFound(NoResourceFoundException ex) {
        Map<String, Object> erro404 = new HashMap<>();
        
        erro404.put("status", 404);
        erro404.put("erro", "Caminho Incorreto");
        erro404.put("mensagem", "Ups! A rota que digitou não existe");
        
        return new ResponseEntity<>(erro404, HttpStatus.NOT_FOUND);
    }

    // --- 2. ERRO DE BI DUPLICADO (Banco de Dados) ---
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, Object> erroBI = new HashMap<>();
        String errorMessage = "Erro de integridade de dados no banco.";
        
        if (ex.getMessage() != null && ex.getMessage().contains("inscricao_bi_key")) {
            errorMessage = "Já existe uma inscrição cadastrada com este número de BI.";
        }

        erroBI.put("timestamp", LocalDateTime.now());
        erroBI.put("status", 400);
        erroBI.put("erro", "Requisição Inválida");
        erroBI.put("mensagem", errorMessage);

        return new ResponseEntity<>(erroBI, HttpStatus.BAD_REQUEST);
    }

    // --- 3. ERRO DE SINTAXE NO JSON (Insomnia) ---
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, Object> erroJson = new HashMap<>();
        
        erroJson.put("timestamp", LocalDateTime.now());
        erroJson.put("status", 400);
        erroJson.put("erro", "JSON Mal Formatado");
        erroJson.put("mensagem", "O corpo da requisição (JSON) possui erros de sintaxe. Verifique se esqueceu de colocar aspas duplas, vírgulas ou chaves.");

        return new ResponseEntity<>(erroJson, HttpStatus.BAD_REQUEST);
    }
}