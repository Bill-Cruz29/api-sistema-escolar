package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Encarregado;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.EncarregadoRepository;

@RestController
@RequestMapping("/api/encarregados")
public class EncarregadoController {

    @Autowired
    private EncarregadoRepository repository;

    @GetMapping
    public List<Encarregado> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Encarregado salvar(@RequestBody Encarregado encarregado) {
        return repository.save(encarregado);
    }
}