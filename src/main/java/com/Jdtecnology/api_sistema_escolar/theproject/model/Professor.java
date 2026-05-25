package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "professor", schema = "public")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "ultimo_nome", length = 100)
    private String ultimoNome;

    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String sexo;

    @Column(length = 150)
    private String morada;

    @Column(length = 15)
    private String contato;

    @Column(length = 50)
    private String nacionalidade;

    @Column(length = 100)
    private String especialidade;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    @Column(precision = 12, scale = 2)
    private BigDecimal salario;

    // Construtor padrão
    public Professor() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUltimoNome() { return ultimoNome; }
    public void setUltimoNome(String ultimoNome) { this.ultimoNome = ultimoNome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getMorada() { return morada; }
    public void setMorada(String morada) { this.morada = morada; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public LocalDate getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDate dataContratacao) { this.dataContratacao = dataContratacao; }

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
}