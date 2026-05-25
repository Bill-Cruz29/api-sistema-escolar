package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    // Usamos Integer porque o id_aluno no seu SQL é do tipo integer
}