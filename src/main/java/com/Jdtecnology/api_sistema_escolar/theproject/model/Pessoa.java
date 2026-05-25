package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa", schema = "public")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "ultimo_nome", nullable = false, length = 100)
    private String ultimoNome;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 100)
    private String curso;

    public Pessoa() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUltimoNome() { return ultimoNome; }
    public void setUltimoNome(String ultimoNome) { this.ultimoNome = ultimoNome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
