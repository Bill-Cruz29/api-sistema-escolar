package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Professor;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.ProfessorRepository;

@RestController
@RequestMapping("/api/professores") // Rota plural para professores
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public List<Professor> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return repository.save(professor);
    }
}