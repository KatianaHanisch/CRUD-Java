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
            if (!tabelaDePrecosRepository.existsById(tabelaDePrecos.getId())) {
                tabelaDePrecos.setId(
                        null == tabelaDePrecosRepository.findMaxId() ? 1 : tabelaDePrecosRepository.findMaxId() + 1);
                tabelaDePrecosRepository.save(tabelaDePrecos);
                return "Tabela de precos cadastrado com sucesso.";
            } else {
                return "Tabela de precos já existe no banco.";
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
        if (tabelaDePrecosRepository.existsById(tabelaDePrecos.getId())) {
            try {
                List<TabelaDePrecos> tabelaDePrecoss = tabelaDePrecosRepository.findById(tabelaDePrecos.getId());
                tabelaDePrecoss.stream().forEach(s -> {
                    TabelaDePrecos tabelaDePrecosToBeUpdate = tabelaDePrecosRepository.findById(s.getId()).get(0);
                    tabelaDePrecosToBeUpdate.setPreco(tabelaDePrecos.getPreco());
                    tabelaDePrecosToBeUpdate.setTipo(tabelaDePrecos.getTipo());
                    tabelaDePrecosRepository.save(tabelaDePrecosToBeUpdate);
                });
                return "Tabela de precos atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Tabela de precos não existe no banco.";
        }
    }

    @Transactional
    public String deleteTabelaDePrecos(TabelaDePrecos tabelaDePrecos) {
        if (tabelaDePrecosRepository.existsById(tabelaDePrecos.getId())) {
            try {
                List<TabelaDePrecos> tabelaDePrecoss = tabelaDePrecosRepository.findById(tabelaDePrecos.getId());
                tabelaDePrecoss.stream().forEach(s -> {
                    tabelaDePrecosRepository.delete(s);
                });
                return "Tabela de precos deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Tabela de precos n\u00E3o existe no banco.";
        }
    }
}