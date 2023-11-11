package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.TabelaDePrecos;
import com.apicomsqlite.poo.repository.TabelaDePrecosRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;

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
                Optional<TabelaDePrecos> tabelaPrecos = tabelaDePrecosRepository.findById(tabelaDePrecos.getId());
                if (tabelaPrecos.isPresent()) {
                    TabelaDePrecos tabelaDePrecosToBeUpdate = tabelaPrecos.get();
                    tabelaDePrecosToBeUpdate.setPreco(tabelaDePrecos.getPreco());
                    tabelaDePrecosToBeUpdate.setTipo(tabelaDePrecos.getTipo());
                    tabelaDePrecosRepository.save(tabelaDePrecosToBeUpdate);
                    return "Tabela de preços atualizado.";
                } else {
                    return "Produto não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Produto não existe no banco.";
        }
    }

    @Transactional
    public String deleteTabelaDePrecos(int id) {
        try {
            if (tabelaDePrecosRepository.existsById(id)) {
                tabelaDePrecosRepository.deleteById(id);
                return "Produto deletado com sucesso.";
            } else {
                return "Produto não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
