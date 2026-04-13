package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Ocorrencia;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.OcorrenciaRepository;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository repository;

    @GetMapping
    public List<Ocorrencia> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Ocorrencia salvar(@RequestBody Ocorrencia ocorrencia) {
        return repository.save(ocorrencia);
    }
}