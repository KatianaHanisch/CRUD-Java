package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.TabelaDePrecos;
import com.apicomsqlite.poo.repository.TabelaDePrecosRepository;
import jakarta.transaction.Transactional;

@Service
public class TabelaDePrecosService {

    @Autowired(required = false)
    private TabelaDePrecosRepository tabelaDePrecosRepository;

    @Transactional
    public String createTabelaDePrecos(TabelaDePrecos tabelaDePrecos) {
        try {
            if (!tabelaDePrecosRepository.existsByTipo(tabelaDePrecos.getTipo())) {
                tabelaDePrecos.setId(
                        null == tabelaDePrecosRepository.findMaxId() ? 1 : tabelaDePrecosRepository.findMaxId() + 1);
                tabelaDePrecosRepository.save(tabelaDePrecos);
                return "tipo cadastrado com sucesso.";
            } else {
                return "tipo já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<TabelaDePrecos> readTabelaDePrecos() {
        return tabelaDePrecosRepository.findAll();
    }

    @Transactional
    public String updateTabelaDePrecos(TabelaDePrecos tabelaDePrecos) {
        if (tabelaDePrecosRepository.existsByTipo(tabelaDePrecos.getTipo())) {
            try {
                List<TabelaDePrecos> tabelaDePrecoss = tabelaDePrecosRepository.findByTipo(tabelaDePrecos.getTipo());
                tabelaDePrecoss.stream().forEach(s -> {
                    TabelaDePrecos tabelaDePrecosToBeUpdate = tabelaDePrecosRepository.findById(s.getId()).get();
                    tabelaDePrecosToBeUpdate.setPreco(tabelaDePrecos.getPreco());
                    tabelaDePrecosRepository.save(tabelaDePrecosToBeUpdate);
                });
                return "Tabela de precos atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "tipo não existe no banco.";
        }
    }

    @Transactional
    public String deleteTabelaDePrecos(TabelaDePrecos tabelaDePrecos) {
        if (tabelaDePrecosRepository.existsByTipo(tabelaDePrecos.getTipo())) {
            try {
                List<TabelaDePrecos> tabelaDePrecoss = tabelaDePrecosRepository.findByTipo(tabelaDePrecos.getTipo());
                tabelaDePrecoss.stream().forEach(s -> {
                    tabelaDePrecosRepository.delete(s);
                });
                return "tipo deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "tipo n\u00E3o existe no banco.";
        }
    }
}