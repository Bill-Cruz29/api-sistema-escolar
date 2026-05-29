package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Turma;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
        .map(Turma -> ResponseEntity.ok().body(Turma))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Turma> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Turma salvar(@RequestBody Turma turma) {
        return repository.save(turma);
    }
}
