package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // Garante que este import está aqui!

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
    Optional<Aluno> findByBi(String bi);
}