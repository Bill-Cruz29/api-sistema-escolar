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

import com.Jdtecnology.api_sistema_escolar.theproject.model.Disciplina;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
        .map(Disciplina -> ResponseEntity.ok().body(Disciplina))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Disciplina> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Disciplina salvar(@RequestBody Disciplina disciplina) {
        return repository.save(disciplina);
    }
}