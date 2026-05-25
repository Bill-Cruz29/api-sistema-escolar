package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Frequencia;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.FrequenciaRepository;

@RestController
@RequestMapping("/api/frequencias")
public class FrequenciaController {

    @Autowired
    private FrequenciaRepository repository;

    @GetMapping
    public List<Frequencia> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Frequencia salvar(@RequestBody Frequencia frequencia) {
        return repository.save(frequencia);
    }
}
