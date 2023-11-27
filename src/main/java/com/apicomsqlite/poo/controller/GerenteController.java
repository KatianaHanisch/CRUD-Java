package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.Empregado;
import com.apicomsqlite.poo.enity.Gerente;
import com.apicomsqlite.poo.service.GerenteService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @RequestMapping(value = "gerente", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createGerente", method = RequestMethod.POST)
    public String createGerente(@RequestBody Gerente gerente) {
        return gerenteService.createGerente(gerente);
    }

    @RequestMapping(value = "readGerente", method = RequestMethod.GET)
    public List<Gerente> readGerente() {
        return gerenteService.readGerente();
    }

    @RequestMapping(value = "updateGerente/{id}", method = RequestMethod.PUT)
    public String updateGerente(@PathVariable int id, @RequestBody Gerente gerente) {
        gerente.setId(id);
        return gerenteService.updateGerente(gerente);
    }

    @RequestMapping(value = "deleteGerente/{id}", method = RequestMethod.DELETE)
    public String deleteGerente(@PathVariable int id) {
        return gerenteService.deleteGerente(id);
    }
}
