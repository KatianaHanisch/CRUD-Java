package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Producao;
import com.apicomsqlite.poo.service.ProducaoService;

@RestController
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @RequestMapping(value = "estoque", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createProducao", method = RequestMethod.POST)
    public String createProducao(@RequestBody Producao estoque) {
        return producaoService.createProducao(estoque);
    }

    @RequestMapping(value = "readProducao", method = RequestMethod.GET)
    public List<Producao> readProducao() {
        return producaoService.readProducao();
    }

    @RequestMapping(value = "updateProducao", method = RequestMethod.PUT)
    public String updateProducao(@RequestBody Producao estoque) {
        return producaoService.updateProducao(estoque);
    }

    @RequestMapping(value = "deleteProducao", method = RequestMethod.DELETE)
    public String deleteProducao(@RequestBody Producao estoque) {
        return producaoService.deleteProducao(estoque);
    }
}
