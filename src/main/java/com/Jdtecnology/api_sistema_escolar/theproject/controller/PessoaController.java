package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Pessoa;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
}