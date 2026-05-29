package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ano_lectivo", schema = "public")
public class AnoLectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ano")
    private Integer id;

    @Column(nullable = false, length = 10)
    private String ano; 

    // Construtor padrão
    public AnoLectivo() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }
}