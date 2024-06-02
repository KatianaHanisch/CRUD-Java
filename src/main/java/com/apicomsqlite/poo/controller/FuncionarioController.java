package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.Funcionario;
import com.apicomsqlite.poo.service.FuncionarioService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(value = "funcionario", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createFuncionario", method = RequestMethod.POST)
    public String createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }

    @RequestMapping(value = "readFuncionarios", method = RequestMethod.GET)
    public List<Funcionario> readFuncionarios() {
        return funcionarioService.readFuncionario();
    }

    @RequestMapping(value = "updateFuncionario/{id}", method = RequestMethod.PUT)
    public String updateFuncionario(@PathVariable int id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
        return funcionarioService.updateFuncionario(funcionario);
    }

    @RequestMapping(value = "deleteFuncionario/{id}", method = RequestMethod.DELETE)
    public String deleteFuncionario(@PathVariable int id) {
        return funcionarioService.deleteFuncionario(id);
    }
}
