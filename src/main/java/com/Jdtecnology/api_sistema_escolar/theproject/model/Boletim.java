package com.Jdtecnology.api_sistema_escolar.theproject.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boletim", schema = "public")
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boletim")
    private Integer id;

    @Column(name = "id_aluno", nullable = false)
    private Integer idAluno;

    @Column(name = "id_periodo", nullable = false)
    private Integer idPeriodo;

    @Column(precision = 5, scale = 2)
    private BigDecimal media;

    // Construtor padrão
    public Boletim() {}

    // Getters e Setters    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }
    public Integer getIdPeriodo() { return idPeriodo; }
    public void setIdPeriodo(Integer idPeriodo) { this.idPeriodo = idPeriodo; }
    public BigDecimal getMedia() { return media; }
    public void setMedia(BigDecimal media) { this.media = media; }
}
