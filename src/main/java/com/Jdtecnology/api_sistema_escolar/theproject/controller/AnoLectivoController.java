package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.AnoLectivo;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AnoLectivoRepository;

@RestController
@RequestMapping("/api/anos-lectivos")
public class AnoLectivoController {

    @Autowired
    private AnoLectivoRepository repository;

    @GetMapping
    public List<AnoLectivo> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public AnoLectivo salvar(@RequestBody AnoLectivo anoLectivo) {
        return repository.save(anoLectivo);
    }
}