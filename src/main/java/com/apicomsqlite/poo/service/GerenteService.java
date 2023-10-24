package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Gerente;
import com.apicomsqlite.poo.repository.GerenteRepository;
import jakarta.transaction.Transactional;

@Service
public class GerenteService {

    @Autowired(required = false)
    private GerenteRepository gereteRepository;

    @Transactional
    public String createGerente(Gerente gerente) {
        try {
            if (!gereteRepository.existsById(gerente.getId())) {
                gerente.setId(null == gereteRepository.findMaxId() ? 1 : gereteRepository.findMaxId() + 1);
                gereteRepository.save(gerente);
                return "gerente cadastrado com sucesso.";
            } else {
                return "gerente já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Gerente> readGerente() {
        return gereteRepository.findAll();
    }

    @Transactional
    public String updateGerente(Gerente gerente) {
        if (gereteRepository.existsById(gerente.getId())) {
            try {
                List<Gerente> gerentes = gereteRepository.findById(gerente.getId());
                gerentes.stream().forEach(s -> {
                    Gerente gerenteToBeUpdate = gereteRepository.findById(s.getId()).get(0);
                    gerenteToBeUpdate.setNome(gerente.getNome());
                    gerenteToBeUpdate.setSetor(gerente.getSetor());
                    gereteRepository.save(gerenteToBeUpdate);
                });
                return "gerente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "gerente não existe no banco.";
        }
    }

    @Transactional
    public String deleteGerente(Gerente gerente) {
        if (gereteRepository.existsById(gerente.getId())) {
            try {
                List<Gerente> gerentes = gereteRepository.findById(gerente.getId());
                gerentes.stream().forEach(s -> {
                    gereteRepository.delete(s);
                });
                return "gerente deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "gerente n\u00E3o existe no banco.";
        }
    }
}