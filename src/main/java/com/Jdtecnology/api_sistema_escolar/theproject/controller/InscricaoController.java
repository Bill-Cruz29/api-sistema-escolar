package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Inscricao;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.InscricaoRepository;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository repository;

    @GetMapping
    public List<Inscricao> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Inscricao salvar(@RequestBody Inscricao inscricao) {
        return repository.save(inscricao);
    }
}