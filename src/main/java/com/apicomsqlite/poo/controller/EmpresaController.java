package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Empresa;
import com.apicomsqlite.poo.service.EmpresaService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "empresa", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createEmpresa", method = RequestMethod.POST)
    public String createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }

    @RequestMapping(value = "readEmpresa", method = RequestMethod.GET)
    public List<Empresa> readEmpresa() {
        return empresaService.readEmpresa();
    }

    @RequestMapping(value = "updateEmpresa/{id}", method = RequestMethod.PUT)
    public String updateEmpresa(@PathVariable int id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        return empresaService.updateEmpresa(empresa);
    }

    @RequestMapping(value = "deleteEmpresa/{id}", method = RequestMethod.DELETE)
    public String deleteEmpresa(@PathVariable int id) {
        return empresaService.deleteEmpresa(id);
    }
}
