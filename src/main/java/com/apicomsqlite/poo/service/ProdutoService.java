package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Produto;
import com.apicomsqlite.poo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired(required = false)
    private ProdutoRepository produtoRepository;

    @Transactional
    public String createProduto(Produto produto) {
        try {
            if (!produtoRepository.existsByNome(produto.getNome())) {
                produto.setId(null == produtoRepository.findMaxId() ? 1 : produtoRepository.findMaxId() + 1);
                produtoRepository.save(produto);

                return "produto cadastrado com sucesso.";
            } else {
                return "Já existe um produto com o nome fornecido no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Produto> readProduto() {
        return produtoRepository.findAll();
    }

    @Transactional
    public String updateProduto(Produto produto) {

        if (produtoRepository.existsById(produto.getId())) {
            try {

                Optional<Produto> produtoOptional = produtoRepository.findById(produto.getId());

                if (produtoOptional.isPresent()) {
                    Produto produtoToBeUpdate = produtoOptional.get();

                    if (produtoRepository.existsById(produto.getId())) {

                        produtoToBeUpdate.setIdEmpresa(produto.getIdEmpresa());
                        produtoToBeUpdate.setNome(produto.getNome());
                        produtoToBeUpdate.setValor(produto.getValor());

                        produtoRepository.save(produtoToBeUpdate);

                        return "produto atualizado com sucesso.";
                    } else {
                        return "Já existe um produto com o nome fornecido.";
                    }
                } else {
                    return "produto não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto não existe no banco.";
        }
    }

    @Transactional
    public String deleteProduto(int id) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.deleteById(id);
                return "produto deletado com sucesso.";
            } else {
                return "produto não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public double getPrecoUnitarioPorNome(String nomeProduto) {
        Optional<Produto> produtoOptional = produtoRepository.findByNome(nomeProduto);
        if (produtoOptional.isPresent()) {
            return produtoOptional.get().getValor();
        } else {
            throw new RuntimeException("Produto não encontrado.");
        }
    }
}
