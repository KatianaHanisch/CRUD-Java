package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Terceirizado;
import com.apicomsqlite.poo.service.TerceirizadoService;

@RestController
public class TerceirizadoController {

    @Autowired
    private TerceirizadoService terceirizadoService;

    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createProduto", method = RequestMethod.POST)
    public String createProduto(@RequestBoducao producao) {
        return terceirizadoService.createProduto(produto);
    }

    @RequestMapping(value = "readProduto", method = RequestMethod.GET)
    public List<Terceirizado> readProdutos() {
        return terceirizadoService.readProduto();
    }

    @RequestMapping(value = "updateProduto", method = RequestMethod.PUT)
    public String updateProduto(@RequestBody Terceirizado produto) {
        return terceirizadoService.updateProduto(produto);
    }

    @RequestMapping(value = "deleteProduto", method = RequestMethod.DELETE)
    public String deleteProduto(@RequestBody Terceirizado produto) {
        return terceirizadoService.deleteProduto(produto);
    }
}
