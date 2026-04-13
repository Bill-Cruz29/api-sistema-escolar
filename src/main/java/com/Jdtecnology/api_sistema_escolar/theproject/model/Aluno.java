package com.Jdtecnology.api_sistema_escolar.theproject.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno", schema = "public")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno") 
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "ultimo_nome", length = 100)
    private String ultimoNome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String email;

    @Column(length = 10)
    private String sexo;

    @Column(length = 150)
    private String morada;

    @Column(length = 15)
    private String contato;

    @Column(length = 20)
    private String bi;

    @Column(length = 50)
    private String nacionalidade;

    @Column(name = "nome_encarregado", length = 100)
    private String nomeEncarregado;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "id_encarregado")
    private Integer idEncarregado;

    public Aluno() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUltimoNome() { return ultimoNome; }
    public void setUltimoNome(String ultimoNome) { this.ultimoNome = ultimoNome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getMorada() { return morada; }
    public void setMorada(String morada) { this.morada = morada; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public String getBi() { return bi; }
    public void setBi(String bi) { this.bi = bi; }
    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }
    public String getNomeEncarregado() { return nomeEncarregado; }
    public void setNomeEncarregado(String nomeEncarregado) { this.nomeEncarregado = nomeEncarregado; }
    public Integer getIdCurso() { return idCurso; }
    public void setIdCurso(Integer idCurso) { this.idCurso = idCurso; }
    public Integer getIdEncarregado() { return idEncarregado; }
    public void setIdEncarregado(Integer idEncarregado) { this.idEncarregado = idEncarregado; }
}