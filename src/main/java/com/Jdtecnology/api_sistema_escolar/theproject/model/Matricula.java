package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula", schema = "public")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Integer id;

    @Column(name = "id_aluno", nullable = false)
    private Integer idAluno;

    @Column(name = "id_ano", nullable = false)
    private Integer idAno;

    public Matricula() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }
    public Integer getIdAno() { return idAno; }
    public void setIdAno(Integer idAno) { this.idAno = idAno; }
}