package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.AtribuicaoTurma;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AtribuicaoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atribuicoes-turmas")
public class AtribuicaoTurmaController {

    @Autowired
    private AtribuicaoTurmaRepository repository;

    @GetMapping
    public List<AtribuicaoTurma> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public AtribuicaoTurma salvar(@RequestBody AtribuicaoTurma atribuicao) {
        return repository.save(atribuicao);
    }
}