package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Boletim;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.BoletimRepository;

@RestController
@RequestMapping("/api/boletins")
public class BoletimController {

    @Autowired
    private BoletimRepository repository;

    @GetMapping
    public List<Boletim> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Boletim salvar(@RequestBody Boletim boletim) {
        return repository.save(boletim);
    }
}