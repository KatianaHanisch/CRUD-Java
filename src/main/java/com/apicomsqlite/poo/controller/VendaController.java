package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.Venda;
import com.apicomsqlite.poo.service.VendaService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class VendaController {

    @Autowired
    private VendaService vendaService;

    @RequestMapping(value = "venda", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createVenda", method = RequestMethod.POST)
    public String createVenda(@RequestBody Venda venda) {
        return vendaService.createVenda(venda);
    }

    @RequestMapping(value = "readVendas", method = RequestMethod.GET)
    public List<Venda> readVenda() {
        return vendaService.readVenda();
    }

    @RequestMapping(value = "updateVenda/{id}", method = RequestMethod.PUT)
    public String updateVenda(@PathVariable int id, @RequestBody Venda venda) {
        venda.setId(id);
        return vendaService.updateVenda(venda);
    }

    @RequestMapping(value = "deleteVenda/{id}", method = RequestMethod.DELETE)
    public String deleteVenda(@PathVariable int id) {
        return vendaService.deleteVenda(id);
    }
}
