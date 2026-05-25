package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Exame;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.ExameRepository;

@RestController
@RequestMapping("/api/exames")
public class ExameController {

    @Autowired
    private ExameRepository repository;

    @GetMapping
    public List<Exame> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Exame salvar(@RequestBody Exame exame) {
        return repository.save(exame);
    }
}