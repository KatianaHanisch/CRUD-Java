package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Usuario;
import com.apicomsqlite.poo.repository.GerenteRepository;
import jakarta.transaction.Transactional;

@Service
public class TerceirizadoService {

    @Autowired(required = false)
    private GerenteRepository clienteRepository;

    @Transactional
    public String createCliente(Usuario cliente) {
        try {
            if (!clienteRepository.existsByNome(cliente.getNome())) {
                cliente.setId(null == clienteRepository.findMaxId() ? 1 : clienteRepository.findMaxId() + 1);
                clienteRepository.save(cliente);
                return "cliente cadastrado com sucesso.";
            } else {
                return "cliente já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Usuario> readCliente() {
        return clienteRepository.findAll();
    }

    @Transactional
    public String updateCliente(Usuario cliente) {
        if (clienteRepository.existsByNome(cliente.getNome())) {
            try {
                List<Usuario> clientes = clienteRepository.findByNome(cliente.getNome());
                clientes.stream().forEach(s -> {
                    Usuario clienteToBeUpdate = clienteRepository.findById(s.getId()).get();
                    clienteToBeUpdate.setCpf(cliente.getCpf());
                    clienteRepository.save(clienteToBeUpdate);
                });
                return "cliente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cliente não existe no banco.";
        }
    }

    @Transactional
    public String deleteCliente(Usuario cliente) {
        if (clienteRepository.existsByNome(cliente.getNome())) {
            try {
                List<Usuario> clientes = clienteRepository.findByNome(cliente.getNome());
                clientes.stream().forEach(s -> {
                    clienteRepository.delete(s);
                });
                return "cliente deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "cliente n\u00E3o existe no banco.";
        }
    }
}