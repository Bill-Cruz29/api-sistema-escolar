package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Curso;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return repository.save(curso);
    }
}