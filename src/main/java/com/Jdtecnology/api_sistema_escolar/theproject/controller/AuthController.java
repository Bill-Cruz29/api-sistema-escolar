package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Usuario;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Conexão com o React
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        // 1. Verificar se o utilizador existe
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
        
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Utilizador não encontrado!"));
        }

        Usuario usuario = usuarioOpt.get();

        // 2. Verificar a senha (Comparação simples direta)
        if (!usuario.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Senha incorreta!"));
        }

        // 3. Sucesso: Devolve os dados do utilizador logado para o React usar
        return ResponseEntity.ok(Map.of(
            "message", "Login efetuado com sucesso!",
            "username", usuario.getUsername(),
            "nomeCompleto", usuario.getNomeCompleto(),
            "role", usuario.getRole()
        ));
    }
}