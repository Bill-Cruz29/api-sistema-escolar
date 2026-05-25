package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.PeriodoLectivo;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.PeriodoLectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos-lectivos")
public class PeriodoLectivoController {

    @Autowired
    private PeriodoLectivoRepository repository;

    @GetMapping
    public List<PeriodoLectivo> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public PeriodoLectivo salvar(@RequestBody PeriodoLectivo periodo) {
        return repository.save(periodo);
    }
}
