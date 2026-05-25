package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // Gerencia a entidade Curso com ID do tipo Integer
}