package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.RelatorioDashboardDTO;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AlunoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.ProfessorRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/relatorios")
@CrossOrigin(origins = "http://localhost:3000")
public class RelatorioController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("/dashboard")
    public ResponseEntity<RelatorioDashboardDTO> getDadosDashboard() {
        // 1. Buscar as contagens direto do banco usando os métodos padrão do JPA
        long totalAlunos = alunoRepository.count();
        long totalProfessores = professorRepository.count();
        long totalTurmas = turmaRepository.count();
        
        // 2. Definir uma taxa de ocupação estática ou calculada (Ex: 78%)
        double taxaOcupacao = 78.0;

        // 3. Simulação da distribuição por curso (Podes deixar dinâmico mais tarde)
        Map<String, Long> alunosPorCurso = new HashMap<>();
        alunosPorCurso.put("Ciências e Tecnologias", 85L);
        alunosPorCurso.put("Ciências Económicas", 52L);
        alunosPorCurso.put("Ciências Sociais", 30L);
        alunosPorCurso.put("Formação Geral", 20L);

        // 4. Montar a resposta para o React
        RelatorioDashboardDTO dto = new RelatorioDashboardDTO(
                totalAlunos, 
                totalProfessores, 
                totalTurmas, 
                taxaOcupacao, 
                alunosPorCurso
        );

        return ResponseEntity.ok(dto);
    }
}