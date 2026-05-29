package com.Jdtecnology.api_sistema_escolar.theproject.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota", schema = "public")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer id;

    @Column(name = "id_aluno", nullable = false)
    private Integer idAluno;

    @Column(name = "id_avaliacao", nullable = false)
    private Integer idAvaliacao;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal valor;

    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(length = 50)
    private String trimestre;

    @Column(name = "tipo_avaliacao", length = 50)
    private String tipoAvaliacao;

    @Column(name = "id_periodo")
    private Integer idPeriodo;

   // Construtor padrão
    public Nota() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }

    public Integer getIdAvaliacao() { return idAvaliacao; }
    public void setIdAvaliacao(Integer idAvaliacao) { this.idAvaliacao = idAvaliacao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Integer getIdDisciplina() { return idDisciplina; }
    public void setIdDisciplina(Integer idDisciplina) { this.idDisciplina = idDisciplina; }

    public Integer getIdProfessor() { return idProfessor; }
    public void setIdProfessor(Integer idProfessor) { this.idProfessor = idProfessor; }

    public String getTrimestre() { return trimestre; }
    public void setTrimestre(String trimestre) { this.trimestre = trimestre; }

    public String getTipoAvaliacao() { return tipoAvaliacao; }
    public void setTipoAvaliacao(String tipoAvaliacao) { this.tipoAvaliacao = tipoAvaliacao; }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}