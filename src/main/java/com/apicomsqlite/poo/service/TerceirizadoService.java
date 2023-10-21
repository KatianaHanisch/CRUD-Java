package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Terceirizado;
import com.apicomsqlite.poo.repository.TerceirizadoRepository;
import jakarta.transaction.Transactional;

@Service
public class TerceirizadoService {

    @Autowired(required = false)
    private TerceirizadoRepository terceirizadoRepository;

    @Transactional
    public String createTerceirizado(Terceirizado terceirizado) {
        try {
            if (!terceirizadoRepository.existsByNome(terceirizado.getNome())) {
                terceirizado
                        .setId(null == terceirizadoRepository.findMaxId() ? 1 : terceirizadoRepository.findMaxId() + 1);
                terceirizadoRepository.save(terceirizado);
                return "terceirizado cadastrado com sucesso.";
            } else {
                return "terceirizado já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Terceirizado> readTerceirizado() {
        return terceirizadoRepository.findAll();
    }

    @Transactional
    public String updateTerceirizado(Terceirizado terceirizado) {
        if (terceirizadoRepository.existsByNome(terceirizado.getNome())) {
            try {
                List<Terceirizado> terceirizados = terceirizadoRepository.findByNome(terceirizado.getNome());
                terceirizados.stream().forEach(s -> {
                    Terceirizado terceirizadoToBeUpdate = terceirizadoRepository.findById(s.getId()).get();
                    terceirizadoToBeUpdate.setFuncao(terceirizado.getFuncao());
                    terceirizadoRepository.save(terceirizadoToBeUpdate);
                });
                return "terceirizado atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "terceirizado não existe no banco.";
        }
    }

    @Transactional
    public String deleteTerceirizado(Terceirizado terceirizado) {
        if (terceirizadoRepository.existsByNome(terceirizado.getNome())) {
            try {
                List<Terceirizado> terceirizados = terceirizadoRepository.findByNome(terceirizado.getNome());
                terceirizados.stream().forEach(s -> {
                    terceirizadoRepository.delete(s);
                });
                return "terceirizado deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "terceirizado n\u00E3o existe no banco.";
        }
    }
}