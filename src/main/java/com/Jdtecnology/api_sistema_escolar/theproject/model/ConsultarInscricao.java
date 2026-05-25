package com.Jdtecnology.api_sistema_escolar.theproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultar_inscricao", schema = "public")
public class ConsultarInscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer id;

    @Column(name = "numero_protocolo", nullable = false, unique = true, length = 50)
    private String numeroProtocolo;

    @Column(nullable = false, length = 20)
    private String bi;

    // Relação direta com a Entidade Inscricao usando a FK id_inscricao
    @OneToOne
    @JoinColumn(name = "id_inscricao", referencedColumnName = "id_inscricao", nullable = false)
    private Inscricao inscricao;

    public ConsultarInscricao() {}

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNumeroProtocolo() { return numeroProtocolo; }
    public void setNumeroProtocolo(String numeroProtocolo) { this.numeroProtocolo = numeroProtocolo; }

    public String getBi() { return bi; }
    public void setBi(String bi) { this.bi = bi; }

    public Inscricao getInscricao() { return inscricao; }
    public void setInscricao(Inscricao inscricao) { this.inscricao = inscricao; }
}