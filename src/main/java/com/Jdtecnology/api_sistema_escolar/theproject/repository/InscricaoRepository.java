package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
}