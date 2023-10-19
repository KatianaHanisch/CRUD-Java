package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Gerente;
import com.apicomsqlite.poo.service.GerenteService;

@RestController
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @RequestMapping(value = "pessoa", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createCliente", method = RequestMethod.POST)
    public String createCliente(@RequestBody Gerente pessoa) {
        return gerenteService.createCliente(pessoa);
    }

    @RequestMapping(value = "readCliente", method = RequestMethod.GET)
    public List<Gerente> readCliente() {
        return gerenteService.readCliente();
    }

    @RequestMapping(value = "updateCliente", method = RequestMethod.PUT)
    public String updateCliente(@RequestBody Gerente pessoa) {
        return gerenteService.updateCliente(pessoa);
    }

    @RequestMapping(value = "deleteCliente", method = RequestMethod.DELETE)
    public String deleteCliente(@RequestBody Gerente pessoa) {
        return gerenteService.deleteCliente(pessoa);
    }
}
