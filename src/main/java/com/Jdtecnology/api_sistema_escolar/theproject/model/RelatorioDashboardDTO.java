package com.Jdtecnology.api_sistema_escolar.theproject.model; // ALTERADO PARA .model

import java.util.Map;

public class RelatorioDashboardDTO {
    private long totalAlunos;
    private long totalProfessores;
    private long totalTurmas;
    private double taxaOcupacao;
    private Map<String, Long> alunosPorCurso;

    // Construtor padrão
    public RelatorioDashboardDTO(long totalAlunos, long totalProfessores, long totalTurmas, double taxaOcupacao, Map<String, Long> alunosPorCurso) {
        this.totalAlunos = totalAlunos;
        this.totalProfessores = totalProfessores;
        this.totalTurmas = totalTurmas;
        this.taxaOcupacao = taxaOcupacao;
        this.alunosPorCurso = alunosPorCurso;
    }

    // Getters e Setters
    public long getTotalAlunos() { return totalAlunos; }
    public long getTotalProfessores() { return totalProfessores; }
    public long getTotalTurmas() { return totalTurmas; }
    public double getTaxaOcupacao() { return taxaOcupacao; }
    public Map<String, Long> getAlunosPorCurso() { return alunosPorCurso; }
}