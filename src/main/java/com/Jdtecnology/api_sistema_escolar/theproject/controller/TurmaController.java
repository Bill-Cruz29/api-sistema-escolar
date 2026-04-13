package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Turma;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public List<Turma> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Turma salvar(@RequestBody Turma turma) {
        return repository.save(turma);
    }
}
