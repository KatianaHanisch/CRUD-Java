package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.apicomsqlite.poo.enity.Empregado;
import com.apicomsqlite.poo.enity.Gerente;
import com.apicomsqlite.poo.repository.EmpregadoRepository;
import com.apicomsqlite.poo.repository.GerenteRepository;

@Service
public class AutenticacaoService {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    public AuthResponse login(String emailString, String senha) {
        List<Gerente> gerentes = gerenteRepository.findByEmail(emailString);

        try {
            if (!gerentes.isEmpty()) {
                Gerente gerente = gerentes.get(0);
                return new AuthResponse(gerente.getNome(), senha.equals(gerente.getSenha()), "gerente");
            }
        } catch (Exception e) {
            throw e;
        }

        List<Empregado> empregados = empregadoRepository.findByEmail(emailString);
        try {
            if (!empregados.isEmpty()) {
                Empregado empregado = empregados.get(0);
                return new AuthResponse(empregado.getNome(), senha.equals(empregado.getSenha()), "empregado");
            }
        } catch (Exception e) {
            throw e;
        }

        // Se nenhum usuário for encontrado, lança uma exceção específica com o status
        // 404
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }

    public static class AuthResponse {
        private final String nome;
        private final boolean autenticado;
        private final String tipo;

        public AuthResponse(String nome, boolean autenticado, String tipo) {
            this.nome = nome;
            this.autenticado = autenticado;
            this.tipo = tipo;
        }

        public String getNome() {
            return nome;
        }

        public boolean isAutenticado() {
            return autenticado;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
