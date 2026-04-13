package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turma", schema = "public")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    public Turma() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdCurso() { return idCurso; }
    public void setIdCurso(Integer idCurso) { this.idCurso = idCurso; }
}
