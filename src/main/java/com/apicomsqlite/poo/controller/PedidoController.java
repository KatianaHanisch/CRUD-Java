package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Pedido;
import com.apicomsqlite.poo.service.PedidoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class PedidoController {

    @Autowired
    private PedidoService pedidosService;

    @RequestMapping(value = "pedido", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createPedido", method = RequestMethod.POST)
    public String createPedido(@RequestBody Pedido pedido) {
        return pedidosService.createPedido(pedido);
    }

    @RequestMapping(value = "readPedido", method = RequestMethod.GET)
    public List<Pedido> readPedido() {
        return pedidosService.readPedido();
    }

    @RequestMapping(value = "updatePedido/{id}", method = RequestMethod.PUT)
    public String updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidosService.updatePedido(pedido);
    }

    @RequestMapping(value = "deletePedido/{id}", method = RequestMethod.DELETE)
    public String deletePedido(@PathVariable int id) {
        return pedidosService.deletePedido(id);
    }
}
