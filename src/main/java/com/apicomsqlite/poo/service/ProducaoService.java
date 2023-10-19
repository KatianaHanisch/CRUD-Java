package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Producao;
import com.apicomsqlite.poo.repository.ProducaoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProducaoService {

    @Autowired(required = false)
    private ProducaoRepository producaoRepository;

    @Transactional
    public String createProduto(Producao produto) {
        try {
            if (!producaoRepository.existsByNome(produto.getNome())) {
                produto.setId(null == producaoRepository.findMaxId() ? 1 : producaoRepository.findMaxId() + 1);
                producaoRepository.save(produto);
                return "produto cadastrado com sucesso.";
            } else {
                return "produto já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producao> readProduto() {
        return producaoRepository.findAll()ducao

    @Transactional
    public String updateProduto(Producao produto) {
        if (producaoRepository.existsByNome(produto.getNome())) {
            try {
                List<Producao> produtos = producaoRepository.findByNome(produto.getNome());
                produtos.stream().forEach(s -> {
                    Producao produtoToBeUpdate = producaoRepository.findById(s.getId()).get();
                    produtoToBeUpdate.setUnidadeDeMedida(produto.getUnidadeDeMedida());
                    produtoToBeUpdate.setValorProduto(produto.getValorProduto());
                    producaoRepository.save(produtoToBeUpdate);
                });
                return "produto atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto não existe no banco.";
        }
    }

    @Transactional
    public String deleteProduto(Producao produto) {
        if (producaoRepository.existsByNome(produto.getNome())) {
            try {
                List<Producao> produtos = producaoRepository.findByNome(produto.getNome());
                produtos.stream().forEach(s -> {
                    producaoRepository.delete(s);
                });
                return "produto deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "produto n\u00E3o existe no banco.";
        }
    }
}