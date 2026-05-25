package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Membros;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.MembrosRepository;

@RestController
@RequestMapping("/api/membros")
public class MembrosController {

    @Autowired
    private MembrosRepository repository;

    @GetMapping
    public List<Membros> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Membros salvar(@RequestBody Membros membro) {
        return repository.save(membro);
    }
}
