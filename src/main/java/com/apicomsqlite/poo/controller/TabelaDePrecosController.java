package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.TabelaDePrecos;
import com.apicomsqlite.poo.service.TabelaDePrecosService;

@RestController
public class TabelaDePrecosController {

    @Autowired
    private TabelaDePrecosService tabelaDePrecosService;

    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createProduto", method = RequestMethod.POST)
    public String createProduto(@RequestBoducao producao) {
        return tabelaDePrecosService.createProduto(produto);
    }

    @RequestMapping(value = "readProduto", method = RequestMethod.GET)
    public List<TabelaDePrecos> readProdutos() {
        return tabelaDePrecosService.readProduto();
    }

    @RequestMapping(value = "updateProduto", method = RequestMethod.PUT)
    public String updateProduto(@RequestBody TabelaDePrecos produto) {
        return tabelaDePrecosService.updateProduto(produto);
    }

    @RequestMapping(value = "deleteProduto", method = RequestMethod.DELETE)
    public String deleteProduto(@RequestBody TabelaDePrecos produto) {
        return tabelaDePrecosService.deleteProduto(produto);
    }
}
