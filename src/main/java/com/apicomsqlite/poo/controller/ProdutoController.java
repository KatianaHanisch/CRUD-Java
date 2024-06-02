package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Produto;
import com.apicomsqlite.poo.service.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "produto", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createProduto", method = RequestMethod.POST)
    public String createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @RequestMapping(value = "readProdutos", method = RequestMethod.GET)
    public List<Produto> readProdutos() {
        return produtoService.readProduto();
    }

    @RequestMapping(value = "updateProduto", method = RequestMethod.PUT)
    public String updateProduto(@RequestBody Produto produto) {
        return produtoService.updateProduto(produto);
    }

    @RequestMapping(value = "deleteProduto/{id}", method = RequestMethod.DELETE)
    public String deleteProduto(@PathVariable int id) {
        return produtoService.deleteProduto(id);
    }
}
