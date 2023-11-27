package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

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
            String email = gerente.getEmail();

            if (gereteRepository.findByEmail(email).isEmpty()) {
                if (!gereteRepository.existsById(gerente.getId())) {
                    gerente.setId(null == gereteRepository.findMaxId() ? 1 : gereteRepository.findMaxId() + 1);
                    gereteRepository.save(gerente);
                    return "Gerente cadastrado com sucesso.";
                } else {
                    return "Gerente já existe no banco.";
                }
            } else {
                return "Já existe um gerente com o mesmo e-mail.";
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

                if (gereteRepository.existsByEmailAndIdNot(gerente.getEmail(), gerente.getId())) {
                    return "Já existe um gerente com o mesmo e-mail.";
                }
                Gerente gerenteToBeUpdate = gereteRepository.getById(gerente.getId());
                gerenteToBeUpdate.setNome(gerente.getNome());
                gerenteToBeUpdate.setSetor(gerente.getSetor());
                gerenteToBeUpdate.setSenha(gerente.getSenha());
                gerenteToBeUpdate.setEmail(gerente.getEmail());

                gereteRepository.save(gerenteToBeUpdate);

                return "Gerente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Gerente não existe no banco.";
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