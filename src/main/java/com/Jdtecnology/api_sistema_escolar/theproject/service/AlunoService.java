package com.Jdtecnology.api_sistema_escolar.theproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.Jdtecnology.api_sistema_escolar.theproject.model.Aluno;
import com.Jdtecnology.api_sistema_escolar.theproject.model.Inscricao;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.AlunoRepository;
import com.Jdtecnology.api_sistema_escolar.theproject.repository.InscricaoRepository;

@Service
public class AlunoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno aceitarAluno(Integer idInscricao) {
        
        // 1. Buscar a inscrição correspondente
        Inscricao inscricao = inscricaoRepository.findById(idInscricao)
            .orElseThrow(() -> new RuntimeException("Inscrição não encontrada com o ID: " + idInscricao));

        if (inscricao.getAceito()) {
            throw new RuntimeException("Esta inscrição já foi aceita anteriormente.");
        }

        // 2. Criar o objeto Aluno e mapear/copiar os dados da Inscrição
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(inscricao.getNome());
        novoAluno.setUltimoNome(inscricao.getUltimoNome());
        novoAluno.setSexo(inscricao.getSexo());
        novoAluno.setBi(inscricao.getBi());
        novoAluno.setNacionalidade(inscricao.getNacionalidade());
        novoAluno.setMorada(inscricao.getMorada());
        novoAluno.setTelefone(inscricao.getTelefone());
        novoAluno.setEmail(inscricao.getEmail());
        novoAluno.setDataNascimento(inscricao.getDataNascimento());
        novoAluno.setNomeEncarregado(inscricao.getNomeEncarregado());
        novoAluno.setIdCurso(inscricao.getIdCurso());
        novoAluno.setFoto(inscricao.getFoto());
        novoAluno.setMunicipioResidencia(inscricao.getMunicipioResidencia());
        novoAluno.setMunicipioEscola(inscricao.getMunicipioEscola());
        novoAluno.setTipoEscola(inscricao.getTipoEscola());
        novoAluno.setMediaFinal(inscricao.getMediaFinal());
        novoAluno.setNivelEnsino(inscricao.getNivelEnsino());
        novoAluno.setCertificado(inscricao.getCertificado());
        novoAluno.setClassePretendida(inscricao.getClassePretendida());
        novoAluno.setTurno(inscricao.getTurno());
        novoAluno.setIdAno(inscricao.getIdAno());
        novoAluno.setUltimaClasse(inscricao.getUltimaClasse());
        
        // 3. Salvar o aluno na tabela 'aluno'
        Aluno alunoSalvo = alunoRepository.save(novoAluno);

        // 4. Mudar o status da inscrição para aceito (Faz sumir da área de pendentes)
        inscricao.setAceito(true);
        inscricaoRepository.save(inscricao);

        return alunoSalvo;
    }
}