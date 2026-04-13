package com.Jdtecnology.api_sistema_escolar.theproject.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscricao", schema = "public")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscricao")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "ultimo_nome", nullable = false, length = 100)
    private String ultimoNome;

    @Column(length = 10)
    private String sexo;

    @Column(unique = true, length = 20)
    private String bi;

    @Column(length = 50)
    private String nacionalidade;

    @Column(length = 150)
    private String morada;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 100)
    private String curso;

    @Column(name = "nome_encarregado", nullable = false, length = 150)
    private String nomeEncarregado;

    @Lob 
    @Column(name = "foto")
    private byte[] foto;

    public Inscricao() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUltimoNome() { return ultimoNome; }
    public void setUltimoNome(String ultimoNome) { this.ultimoNome = ultimoNome; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getBi() { return bi; }
    public void setBi(String bi) { this.bi = bi; }
    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }
    public String getMorada() { return morada; }
    public void setMorada(String morada) { this.morada = morada; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public String getNomeEncarregado() { return nomeEncarregado; }
    public void setNomeEncarregado(String nomeEncarregado) { this.nomeEncarregado = nomeEncarregado; }
    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }
}
