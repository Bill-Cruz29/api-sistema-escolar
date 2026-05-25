package com.Jdtecnology.api_sistema_escolar.theproject.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;
import com.Jdtecnology.api_sistema_escolar.theproject.model.AnoLectivo;
import com.Jdtecnology.api_sistema_escolar.theproject.model.Inscricao;
import com.Jdtecnology.api_sistema_escolar.theproject.model.Matricula;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AlunoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AnoLectivoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.InscricaoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.MatriculaRepository;

@RestController
@RequestMapping("/api/custom")
public class MatriculaCustomController {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AnoLectivoRepository anoLectivoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @PostMapping("/efetivar-matricula/{idInscricao}/{idAno}")
    public ResponseEntity<?> efetivar(@PathVariable Integer idInscricao, @PathVariable Integer idAno) {
        
        Optional<Inscricao> inscricaoOpt = inscricaoRepository.findById(idInscricao);
        Optional<AnoLectivo> anoOpt = anoLectivoRepository.findById(idAno);

        if (inscricaoOpt.isEmpty() || anoOpt.isEmpty()) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Inscrição ou Ano Lectivo não encontrado.");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }

        Inscricao inscricao = inscricaoOpt.get();
        AnoLectivo anoLectivo = anoOpt.get();

        // 2. Passa TODOS os dados da inscrição para a tabela de Alunos
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(inscricao.getNome());
        novoAluno.setUltimoNome(inscricao.getUltimoNome());
        novoAluno.setSexo(inscricao.getSexo());
        novoAluno.setNacionalidade(inscricao.getNacionalidade());
        novoAluno.setMorada(inscricao.getMorada());
        novoAluno.setTelefone(inscricao.getTelefone());
        novoAluno.setBi(inscricao.getBi());
        novoAluno.setEmail(inscricao.getEmail());
        novoAluno.setDataNascimento(inscricao.getDataNascimento());
        novoAluno.setNomeEncarregado(inscricao.getNomeEncarregado());
        novoAluno.setFoto(inscricao.getFoto());
        
        // CORREÇÃO AQUI: Usa diretamente o idCurso que mapeámos na entidade Inscricao
        novoAluno.setIdCurso(inscricao.getIdCurso()); 

        // ADICIONANDO OS NOVOS ATRIBUTOS VINDOS DA IMAGEM DO INSOMNIA
        novoAluno.setMunicipioResidencia(inscricao.getMunicipioResidencia());
        novoAluno.setMunicipioEscola(inscricao.getMunicipioEscola());
        novoAluno.setTipoEscola(inscricao.getTipoEscola());
        novoAluno.setMediaFinal(inscricao.getMediaFinal());
        novoAluno.setNivelEnsino(inscricao.getNivelEnsino());
        novoAluno.setCertificado(inscricao.getCertificado());
        novoAluno.setClassePretendida(inscricao.getClassePretendida());

        // Se na sua classe Aluno o campo de telefone se chamar 'contato', use: novoAluno.setContato(inscricao.getTelefone());
        novoAluno.setTelefone(inscricao.getTelefone()); 

        // Guarda no banco de dados para gerar o id_aluno oficial
        novoAluno = alunoRepository.save(novoAluno);

        // 3. Cria a matrícula vinculando o Aluno gerado ao Ano Lectivo
        Matricula novaMatricula = new Matricula();
        novaMatricula.setAluno(novoAluno);
        novaMatricula.setAnoLectivo(anoLectivo);

        matriculaRepository.save(novaMatricula);

        // Retorno de sucesso limpo
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", "Matrícula efetuada com sucesso!");
        resposta.put("aluno", novoAluno.getNome() + " " + novoAluno.getUltimoNome());
        resposta.put("id_aluno_criado", novoAluno.getId());

        return ResponseEntity.ok(resposta);
    }
}