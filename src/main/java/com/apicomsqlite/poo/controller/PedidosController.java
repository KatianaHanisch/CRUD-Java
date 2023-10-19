package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Pedidos;
import com.apicomsqlite.poo.service.PedidosService;

@RestController
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @RequestMapping(value = "venda", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createVenda", method = RequestMethod.POST)
    public String createVenda(@RequestBody Pedidos venda) {
        return pedidosService.createVenda(venda);
    }

    @RequestMapping(value = "readVenda", method = RequestMethod.GET)
    public List<Pedidos> readVendas() {
        return pedidosService.readVenda();
    }

    @RequestMapping(value = "updateVenda", method = RequestMethod.PUT)
    public String updateVenda(@RequestBody Pedidos venda) {
        return pedidosService.updateVenda(venda);
    }

    @RequestMapping(value = "deleteVenda", method = RequestMethod.DELETE)
    public String deleteVenda(@RequestBody Pedidos venda) {
        return pedidosService.deleteVenda(venda);
    }
}
