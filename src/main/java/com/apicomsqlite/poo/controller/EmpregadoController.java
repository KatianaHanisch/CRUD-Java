package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Empregado;
import com.apicomsqlite.poo.service.EmpregadoService;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @RequestMapping(value = "estoque", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createEstoque", method = RequestMethod.POST)
    public String createEstoque(@RequestBody Empregado estoque) {
        return empregadoService.createEstoque(estoque);
    }

    @RequestMapping(value = "readEstoque", method = RequestMethod.GET)
    public List<Empregado> readEstoque() {
        return empregadoService.readEstoque();
    }

    @RequestMapping(value = "updateEstoque", method = RequestMethod.PUT)
    public String updateEstoque(@RequestBody Empregado estoque) {
        return empregadoService.updateEstoque(estoque);
    }

    @RequestMapping(value = "deleteEstoque", method = RequestMethod.DELETE)
    public String deleteEstoque(@RequestBody Empregado estoque) {
        return empregadoService.deleteEstoque(estoque);
    }
}
