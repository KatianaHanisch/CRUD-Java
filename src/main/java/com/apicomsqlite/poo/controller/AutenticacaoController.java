package com.apicomsqlite.poo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicomsqlite.poo.enity.DadosLogin;
import com.apicomsqlite.poo.service.AutenticacaoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public AutenticacaoService.AuthResponse fazerLogin(@RequestBody DadosLogin dadosLogin) {

        return autenticacaoService.login(dadosLogin.getEmail(), dadosLogin.getSenha());
    }
}
