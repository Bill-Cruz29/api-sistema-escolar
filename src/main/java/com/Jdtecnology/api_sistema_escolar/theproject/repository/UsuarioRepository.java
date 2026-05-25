package com.Jdtecnology.api_sistema_escolar.theproject.repository;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}