package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Cliente;
import com.apicomsqlite.poo.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired(required = false)
    private ClienteRepository clienteRepository;

    @Transactional
    public String createCliente(Cliente cliente) {
        try {
            if (!clienteRepository.existsByCpf(cliente.getCpf())) {
                cliente.setId(null == clienteRepository.findMaxId() ? 1 : clienteRepository.findMaxId() + 1);
                clienteRepository.save(cliente);

                return "Cliente cadastrado com sucesso.";
            } else {
                return "Já existe um cliente com o cpf fornecido no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cliente> readCliente() {
        return clienteRepository.findAll();
    }

    @Transactional
    public String updateCliente(Cliente cliente) {

        if (clienteRepository.existsById(cliente.getId())) {
            try {

                Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());

                System.out.println(clienteOptional.isPresent());

                if (clienteOptional.isPresent()) {
                    Cliente clienteToBeUpdate = clienteOptional.get();

                    if (clienteRepository.existsById(cliente.getId())) {

                        clienteToBeUpdate.setIdEmpresa(cliente.getIdEmpresa());
                        clienteToBeUpdate.setNome(cliente.getNome());
                        clienteToBeUpdate.setCpf(cliente.getCpf());

                        clienteRepository.save(clienteToBeUpdate);

                        return "cliente atualizado com sucesso.";
                    } else {
                        return "Já existe um cliente com o cpf fornecido.";
                    }
                } else {
                    return "cliente não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cliente não existe no banco.";
        }
    }

    @Transactional
    public String deleteCliente(int id) {
        try {
            if (clienteRepository.existsById(id)) {
                clienteRepository.deleteById(id);
                return "cliente deletado com sucesso.";
            } else {
                return "cliente não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
