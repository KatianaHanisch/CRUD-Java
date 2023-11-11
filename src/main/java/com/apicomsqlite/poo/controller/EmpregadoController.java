package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Empregado;
import com.apicomsqlite.poo.service.EmpregadoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

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

    @RequestMapping(value = "updateEmpregado/{id}", method = RequestMethod.PUT)
    public String updateEmpregado(@PathVariable int id, @RequestBody Empregado empregado) {
        empregado.setId(id);
        return empregadoService.updateEmpregado(empregado);
    }

    @RequestMapping(value = "deleteEmpregado/{id}", method = RequestMethod.DELETE)
    public String deleteEmpregado(@PathVariable int id) {
        return empregadoService.deleteEmpregado(id);
    }
}
