package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Avaliacao;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    @GetMapping
    public List<Avaliacao> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }
}