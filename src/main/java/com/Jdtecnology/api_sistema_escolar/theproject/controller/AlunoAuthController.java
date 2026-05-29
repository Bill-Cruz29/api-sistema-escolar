package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth-aluno")
@CrossOrigin(origins = "http://localhost:3000") // Conexão com o React do Aluno
public class AlunoAuthController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginAluno(@RequestBody Map<String, String> loginData) {
        String bi = loginData.get("bi"); // O aluno digita o BI ou nº de matrícula
        String telefoneOrSenha = loginData.get("telefone"); // Usando o telefone como validação

        // 1. Procurar o aluno na base de dados pelo BI
        Optional<Aluno> alunoOpt = alunoRepository.findByBi(bi);

        if (alunoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Nº de BI ou Matrícula não encontrado!"));
        }

        Aluno aluno = alunoOpt.get();

        // 2. Validar se o telefone coincide (funciona como a senha inicial do aluno)
        if (aluno.getTelefone() != null && !aluno.getTelefone().equals(telefoneOrSenha)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Credenciais incorretas!"));
        }

        // 3. Sucesso: Retorna os dados necessários para o React montar o Portal do Aluno
        return ResponseEntity.ok(Map.of(
            "message", "Login efetuado com sucesso!",
            "idAluno", aluno.getId(), // O React vai precisar deste ID para buscar as notas dele, então cconectarai com o react
            "nome", aluno.getNome(),
            "classe", aluno.getClassePretendida() != null ? aluno.getClassePretendida() : "Não Matriculado"
        ));
    }
}