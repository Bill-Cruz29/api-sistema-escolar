package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.InscricaoDisciplina;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.InscricaoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes-disciplinas")
public class InscricaoDisciplinaController {

    @Autowired
    private InscricaoDisciplinaRepository repository;

    @GetMapping
    public List<InscricaoDisciplina> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public InscricaoDisciplina salvar(@RequestBody InscricaoDisciplina inscricao) {
        return repository.save(inscricao);
    }
}
