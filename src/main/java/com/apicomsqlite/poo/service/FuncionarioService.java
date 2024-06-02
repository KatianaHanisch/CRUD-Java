package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Funcionario;
import com.apicomsqlite.poo.repository.FuncionarioRepository;

import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

    @Autowired(required = false)
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public String createFuncionario(Funcionario funcionario) {
        try {
            if (!funcionarioRepository.existsById(funcionario.getId())) {
                funcionario
                        .setId(null == funcionarioRepository.findMaxId() ? 1 : funcionarioRepository.findMaxId() + 1);
                funcionarioRepository.save(funcionario);

                return "funcionario cadastrado com sucesso.";
            } else {
                return "funcionario já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Funcionario> readFuncionario() {
        return funcionarioRepository.findAll();
    }

    @Transactional
    public String updateFuncionario(Funcionario funcionario) {

        if (funcionarioRepository.existsById(funcionario.getId())) {
            try {

                Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcionario.getId());

                if (funcionarioOptional.isPresent()) {
                    Funcionario funcionarioToBeUpdate = funcionarioOptional.get();

                    if (funcionarioRepository.existsById(funcionario.getId())) {

                        funcionarioToBeUpdate.setNome(funcionario.getNome());
                        funcionarioToBeUpdate.setIdEmpresa(funcionario.getIdEmpresa());
                        funcionarioToBeUpdate.setCpf(funcionario.getCpf());
                        funcionarioToBeUpdate.setFuncao(funcionario.getFuncao());

                        funcionarioRepository.save(funcionarioToBeUpdate);

                        return "Funcionario atualizado com sucesso.";
                    } else {
                        return "Já existe um funcionario com o cpf fornecido.";
                    }
                } else {
                    return "Funcionario não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Funcionario não existe no banco.";
        }
    }

    @Transactional
    public String deleteFuncionario(int id) {
        try {
            if (funcionarioRepository.existsById(id)) {
                funcionarioRepository.deleteById(id);
                return "Funcionario deletado com sucesso.";
            } else {
                return "Funcionario não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
