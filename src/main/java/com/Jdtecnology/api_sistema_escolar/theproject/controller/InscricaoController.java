package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
            .map(inscricao -> ResponseEntity.ok().body(inscricao))
            .orElse(ResponseEntity.notFound().build());
    }

    // ÁREA 1: Lista TODAS as inscrições (Histórico geral - Aceitos e Pendentes)
    @GetMapping
    public List<Inscricao> listarTodas() {
        return repository.findAll();
    }

    // ÁREA 2: Lista apenas os inscritos que AINDA NÃO FORAM ACEITOS
    @GetMapping("/pendentes")
    public List<Inscricao> listarPendentes() {
        return repository.findByAceitoFalse();
    }

    @PostMapping
    public Inscricao salvar(@RequestBody Inscricao inscricao) {
        return repository.save(inscricao);
    }
}