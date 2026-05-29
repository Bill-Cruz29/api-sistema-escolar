package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
        .map(Curso -> ResponseEntity.ok().body(Curso))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return repository.save(curso);
    }
}