package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Producao;
import com.apicomsqlite.poo.repository.ProducaoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProducaoService {

    @Autowired(required = false)
    private ProducaoRepository producaoRepository;

    @Transactional
    public String createProducao(Producao producao) {
        try {
            if (!producaoRepository.existsById(producao.getId())) {
                producao.setId(null == producaoRepository.findMaxId() ? 1 : producaoRepository.findMaxId() + 1);
                producaoRepository.save(producao);
                return "producao cadastrado com sucesso.";
            } else {
                return "producao já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producao> readProducao() {
        return producaoRepository.findAll();
    }

    @Transactional
    public String updateProducao(Producao producao) {
        if (producaoRepository.existsById(producao.getId())) {
            try {
                Optional<Producao> listaProducao = producaoRepository.findById(producao.getId());
                if (listaProducao.isPresent()) {
                    Producao producaoToBeUpdate = listaProducao.get();
                    producaoToBeUpdate.setFuncao(producao.getFuncao());
                    producaoToBeUpdate.setNome(producao.getNome());
                    producaoRepository.save(producaoToBeUpdate);
                    return "Producao atualizado.";
                } else {
                    return "Producao não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Producao não existe no banco.";
        }
    }

    @Transactional
    public String deleteProducao(int id) {
        try {
            if (producaoRepository.existsById(id)) {
                producaoRepository.deleteById(id);
                return "Producao deletado com sucesso.";
            } else {
                return "Producao não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}