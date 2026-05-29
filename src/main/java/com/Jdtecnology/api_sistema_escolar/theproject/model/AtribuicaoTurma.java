package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atribuicao_turma", schema = "public")
public class AtribuicaoTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atribuicao")
    private Integer id;

    @Column(name = "id_professor", nullable = false)
    private Integer idProfessor;

    @Column(name = "id_turma", nullable = false)
    private Integer idTurma;

    // Construtor padrão
    public AtribuicaoTurma() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdProfessor() { return idProfessor; }
    public void setIdProfessor(Integer idProfessor) { this.idProfessor = idProfessor; }
    public Integer getIdTurma() { return idTurma; }
    public void setIdTurma(Integer idTurma) { this.idTurma = idTurma; }
}
