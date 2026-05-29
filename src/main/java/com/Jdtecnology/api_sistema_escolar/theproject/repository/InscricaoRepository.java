package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Jdtecnology.api_sistema_escolar.theproject.model.Inscricao;
import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
    
    // Busca apenas as inscrições que ainda não foram aceitas (Área 2)
    List<Inscricao> findByAceitoFalse();
    
}