package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aula;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AulaRepository;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public List<Aula> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Aula salvar(@RequestBody Aula aula) {
        return repository.save(aula);
    }
}