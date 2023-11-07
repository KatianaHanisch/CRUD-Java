package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Terceirizado;
import com.apicomsqlite.poo.service.TerceirizadoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class TerceirizadoController {

    @Autowired
    private TerceirizadoService terceirizadoService;

    @RequestMapping(value = "terceirizado", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createTerceirizado", method = RequestMethod.POST)
    public String createTerceirizado(@RequestBody Terceirizado terceirizado) {
        return terceirizadoService.createTerceirizado(terceirizado);
    }

    @RequestMapping(value = "readTerceirizado", method = RequestMethod.GET)
    public List<Terceirizado> readTerceirizados() {
        return terceirizadoService.readTerceirizado();
    }

    @RequestMapping(value = "updateTerceirizado", method = RequestMethod.PUT)
    public String updateTerceirizado(@RequestBody Terceirizado terceirizado) {
        return terceirizadoService.updateTerceirizado(terceirizado);
    }

    @RequestMapping(value = "deleteTerceirizado", method = RequestMethod.DELETE)
    public String deleteTerceirizado(@RequestBody Terceirizado terceirizado) {
        return terceirizadoService.deleteTerceirizado(terceirizado);
    }
}
