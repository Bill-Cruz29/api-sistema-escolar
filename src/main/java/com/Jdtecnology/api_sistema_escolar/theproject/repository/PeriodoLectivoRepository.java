package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.PeriodoLectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoLectivoRepository extends JpaRepository<PeriodoLectivo, Integer> {
}
