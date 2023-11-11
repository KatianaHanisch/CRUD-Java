package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.TabelaDePrecos;
import com.apicomsqlite.poo.service.TabelaDePrecosService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class TabelaDePrecosController {

    @Autowired
    private TabelaDePrecosService tabelaDePrecosService;

    @RequestMapping(value = "tabelaDePrecos", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createTabelaDePrecos", method = RequestMethod.POST)
    public String createTabelaDePrecos(@RequestBody TabelaDePrecos tabelaDePrecos) {
        return tabelaDePrecosService.createTabelaDePrecos(tabelaDePrecos);
    }

    @RequestMapping(value = "readTabelaDePrecos", method = RequestMethod.GET)
    public List<TabelaDePrecos> readTabelaDePrecoss() {
        return tabelaDePrecosService.readTabelaDePrecos();
    }

    @RequestMapping(value = "updateTabelaDePrecos/{id}", method = RequestMethod.PUT)
    public String updateTabelaDePrecos(@PathVariable int id, @RequestBody TabelaDePrecos tabelaDePrecos) {
        tabelaDePrecos.setId(id);
        return tabelaDePrecosService.updateTabelaDePrecos(tabelaDePrecos);
    }

    @RequestMapping(value = "deleteTabelaDePrecos/{id}", method = RequestMethod.DELETE)
    public String deleteTabelaDePrecos(@PathVariable int id) {
        return tabelaDePrecosService.deleteTabelaDePrecos(id);
    }
}
