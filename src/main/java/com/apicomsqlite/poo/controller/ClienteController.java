package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.Cliente;
import com.apicomsqlite.poo.service.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "cliente", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createCliente", method = RequestMethod.POST)
    public String createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    @RequestMapping(value = "readCliente", method = RequestMethod.GET)
    public List<Cliente> readCliente() {
        return clienteService.readCliente();
    }

    @RequestMapping(value = "updateCliente/{id}", method = RequestMethod.PUT)
    public String updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteService.updateCliente(cliente);
    }

    @RequestMapping(value = "deleteCliente/{id}", method = RequestMethod.DELETE)
    public String deleteCliente(@PathVariable int id) {
        return clienteService.deleteCliente(id);
    }
}
