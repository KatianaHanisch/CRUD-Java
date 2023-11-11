package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Producao;
import com.apicomsqlite.poo.service.ProducaoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @RequestMapping(value = "producao", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createProducao", method = RequestMethod.POST)
    public String createProducao(@RequestBody Producao producao) {
        return producaoService.createProducao(producao);
    }

    @RequestMapping(value = "readProducao", method = RequestMethod.GET)
    public List<Producao> readProducao() {
        return producaoService.readProducao();
    }

    @RequestMapping(value = "updateProducao/{id}", method = RequestMethod.PUT)
    public String updateProducao(@PathVariable int id, @RequestBody Producao producao) {
        producao.setId(id);
        return producaoService.updateProducao(producao);
    }

    @RequestMapping(value = "deleteProducao/{id}", method = RequestMethod.DELETE)
    public String deleteProducao(@PathVariable int id) {
        return producaoService.deleteProducao(id);
    }
}
