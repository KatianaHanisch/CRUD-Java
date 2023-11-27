package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

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
            String email = empregado.getEmail();

            if (empregadoRepository.findByEmail(email).isEmpty()) {
                if (!empregadoRepository.existsById(empregado.getId())) {
                    empregado.setId(null == empregadoRepository.findMaxId() ? 1 : empregadoRepository.findMaxId() + 1);
                    empregadoRepository.save(empregado);
                    return "Empregado cadastrado com sucesso.";
                } else {
                    return "Empregado já existe no banco.";
                }

            } else {
                return "Já existe um empregado com o mesmo e-mail.";
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

        if (empregadoRepository.existsById(empregado.getId())) {
            try {

                Optional<Empregado> empregadoOptional = empregadoRepository.findById(empregado.getId());

                if (empregadoOptional.isPresent()) {
                    Empregado empregadoToBeUpdate = empregadoOptional.get();

                    if (!empregadoRepository.existsByEmailAndIdNot(empregado.getEmail(), empregado.getId())) {

                        empregadoToBeUpdate.setNome(empregado.getNome());
                        empregadoToBeUpdate.setSalario(empregado.getSalario());
                        empregadoToBeUpdate.setFuncao(empregado.getFuncao());
                        empregadoToBeUpdate.setSenha(empregado.getSenha());
                        empregadoToBeUpdate.setEmail(empregado.getEmail());

                        empregadoRepository.save(empregadoToBeUpdate);

                        return "Empregado atualizado com sucesso.";
                    } else {
                        return "Já existe um empregado com o email fornecido.";
                    }
                } else {
                    return "Empregado não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Empregado não existe no banco.";
        }
    }

    @Transactional
    public String deleteEmpregado(int id) {
        try {
            if (empregadoRepository.existsById(id)) {
                empregadoRepository.deleteById(id);
                return "Empregado deletado com sucesso.";
            } else {
                return "Empregado não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
