package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    // Usamos Integer porque o id_aluno no seu SQL é do tipo integer
}