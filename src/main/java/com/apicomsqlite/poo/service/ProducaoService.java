package com.apicomsqlite.poo.service;

import java.util.List;

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
                List<Producao> producaos = producaoRepository.findById(producao.getId());
                producaos.stream().forEach(s -> {
                    Producao producaoToBeUpdate = producaoRepository.findById(s.getId()).get(0);
                    producaoToBeUpdate.setFuncao(producao.getFuncao());
                    producaoToBeUpdate.setNome(producao.getNome());
                    producaoRepository.save(producaoToBeUpdate);
                });
                return "producao atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "producao não existe no banco.";
        }
    }

    @Transactional
    public String deleteProducao(Producao producao) {
        if (producaoRepository.existsById(producao.getId())) {
            try {
                List<Producao> producaos = producaoRepository.findById(producao.getId());
                producaos.stream().forEach(s -> {
                    producaoRepository.delete(s);
                });
                return "producao deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "producao n\u00E3o existe no banco.";
        }
    }
}