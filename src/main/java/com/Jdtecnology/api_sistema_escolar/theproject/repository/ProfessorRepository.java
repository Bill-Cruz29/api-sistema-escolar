package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    // Integer porque o id_professor é integer no Postgres
}
