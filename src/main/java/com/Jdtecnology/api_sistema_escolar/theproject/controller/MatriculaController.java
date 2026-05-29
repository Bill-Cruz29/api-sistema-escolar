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

import com.Jdtecnology.api_sistema_escolar.theproject.model.Matricula;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.MatriculaRepository;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
        .map(Matricula -> ResponseEntity.ok().body(Matricula))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Matricula> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Matricula salvar(@RequestBody Matricula matricula) {
        return repository.save(matricula);
    }
}