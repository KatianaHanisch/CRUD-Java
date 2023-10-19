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

    @RequestMapping(value = "createEstoque", method = RequestMethod.POST)
    public String createEstoque(@RequestBody Producao estoque) {
        return producaoService.createEstoque(estoque);
    }

    @RequestMapping(value = "readEstoque", method = RequestMethod.GET)
    public List<Producao> readEstoque() {
        return producaoService.readEstoque();
    }

    @RequestMapping(value = "updateEstoque", method = RequestMethod.PUT)
    public String updateEstoque(@RequestBody Producao estoque) {
        return producaoService.updateEstoque(estoque);
    }

    @RequestMapping(value = "deleteEstoque", method = RequestMethod.DELETE)
    public String deleteEstoque(@RequestBody Producao estoque) {
        return producaoService.deleteEstoque(estoque);
    }
}
