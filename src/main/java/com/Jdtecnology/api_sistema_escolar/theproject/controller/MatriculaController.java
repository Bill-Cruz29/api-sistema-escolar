package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Matricula;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.MatriculaRepository;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping
    public List<Matricula> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Matricula salvar(@RequestBody Matricula matricula) {
        return repository.save(matricula);
    }
}