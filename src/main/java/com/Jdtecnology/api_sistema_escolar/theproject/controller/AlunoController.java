package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AlunoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoService alunoService; // Injeta o serviço criado

    // ÁREA 1: Lista de alunos já aceites e ativos
    @GetMapping
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
        return repository.findById(id)
            .map(aluno -> ResponseEntity.ok().body(aluno))
            .orElse(ResponseEntity.notFound().build());
    }

    // OPERAÇÃO: Aceitar o aluno baseado no ID da Inscrição dele
    @PostMapping("/aceitar/{idInscricao}")
    public ResponseEntity<Aluno> aceitarInscricao(@PathVariable Integer idInscricao) {
        try {
            Aluno alunoMatriculado = alunoService.aceitarAluno(idInscricao);
            return ResponseEntity.ok(alunoMatriculado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }
}