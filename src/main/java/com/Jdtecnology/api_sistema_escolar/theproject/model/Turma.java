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

    @Column(length = 50)
    private String classe;

    @Column(length = 50)
    private String periodo;

    @Column(name = "id_ano")
    private Integer idAno;

    @Column(name = "capacidade_maxima")
    private Integer capacidademaxima;

    // Construtor padrão
    public Turma() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdCurso() { return idCurso; }
    public void setIdCurso(Integer idCurso) { this.idCurso = idCurso; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public Integer getIdAno() { return idAno; }
    public void setIdAno(Integer idAno) { this.idAno = idAno; }

    public Integer getCapacidademaxima() { return capacidademaxima; }
    public void setCapacidademaxima(Integer capacidademaxima) { this.capacidademaxima = capacidademaxima; }
}