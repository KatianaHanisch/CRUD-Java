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

    @RequestMapping(value = "updatePedido", method = RequestMethod.PUT)
    public String updatePedido(@RequestBody Pedido pedido) {
        return pedidosService.updatePedido(pedido);
    }

    @RequestMapping(value = "deletePedido", method = RequestMethod.DELETE)
    public String deletePedido(@RequestBody Pedido pedido) {
        return pedidosService.deletePedido(pedido);
    }
}
