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

    @RequestMapping(value = "empregado", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createEmpregado", method = RequestMethod.POST)
    public String createEmpregado(@RequestBody Empregado empregado) {
        return empregadoService.createEmpregado(empregado);
    }

    @RequestMapping(value = "readEmpregado", method = RequestMethod.GET)
    public List<Empregado> readEmpregado() {
        return empregadoService.readEmpregado();
    }

    @RequestMapping(value = "updateEmpregado", method = RequestMethod.PUT)
    public String updateEmpregado(@RequestBody Empregado empregado) {
        return empregadoService.updateEmpregado(empregado);
    }

    @RequestMapping(value = "deleteEmpregado", method = RequestMethod.DELETE)
    public String deleteEmpregado(@RequestBody Empregado empregado) {
        return empregadoService.deleteEmpregado(empregado);
    }
}
