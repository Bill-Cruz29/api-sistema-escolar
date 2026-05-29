package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscricao_disciplina", schema = "public")
public class InscricaoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscricao")
    private Integer id;

    @Column(name = "id_aluno", nullable = false)
    private Integer idAluno;

    @Column(name = "id_disciplina", nullable = false)
    private Integer idDisciplina;

    @Column(name = "id_ano", nullable = false)
    private Integer idAno;

    @Column(name = "id_periodo", nullable = false)
    private Integer idPeriodo;

    // Construtor padrão
    public InscricaoDisciplina() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }
    public Integer getIdDisciplina() { return idDisciplina; }
    public void setIdDisciplina(Integer idDisciplina) { this.idDisciplina = idDisciplina; }
    public Integer getIdAno() { return idAno; }
    public void setIdAno(Integer idAno) { this.idAno = idAno; }
    public Integer getIdPeriodo() { return idPeriodo; }
    public void setIdPeriodo(Integer idPeriodo) { this.idPeriodo = idPeriodo; }
}
