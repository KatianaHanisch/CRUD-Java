package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Empregado;
import com.apicomsqlite.poo.repository.EmpregadoRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpregadoService {

    @Autowired(required = false)
    private EmpregadoRepository empregadoRepository;

    @Transactional
    public String createEmpregado(Empregado empregado) {
        try {
            if (!empregadoRepository.existsByNome(empregado.getNome())) {
                empregado.setId(null == empregadoRepository.findMaxId() ? 1 : empregadoRepository.findMaxId() + 1);
                empregadoRepository.save(empregado);
                return "quantidade cadastrado com sucesso.";
            } else {
                return "quantidade já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Empregado> readEmpregado() {
        return empregadoRepository.findAll();
    }

    @Transactional
    public String updateEmpregado(Empregado empregado) {
        if (empregadoRepository.existsByNome(empregado.getNome())) {
            try {
                List<Empregado> empregados = empregadoRepository.findByNome(empregado.getNome());
                empregados.stream().forEach(s -> {
                    Empregado empregadoToBeUpdate = empregadoRepository.findById(s.getId()).get();
                    empregadoToBeUpdate.setSalario(empregado.getSalario());
                    empregadoToBeUpdate.setFuncao(empregado.getFuncao());
                    empregadoRepository.save(empregadoToBeUpdate);
                });
                return "empregado atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "empregado não existe no banco.";
        }
    }

    @Transactional
    public String deleteEmpregado(Empregado empregado) {
        if (empregadoRepository.existsByNome(empregado.getNome())) {
            try {
                List<Empregado> empregados = empregadoRepository.findByNome(empregado.getNome());
                empregados.stream().forEach(s -> {
                    empregadoRepository.delete(s);
                });
                return "empregado deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "empregado n\u00E3o existe no banco.";
        }
    }
}
