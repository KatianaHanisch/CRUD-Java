package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Venda;
import com.apicomsqlite.poo.repository.VendaRepository;
import jakarta.transaction.Transactional;

@Service
public class VendaService {

    @Autowired(required = false)
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public String createVenda(Venda venda) {
        try {

            if (!produtoService.existsByNome(venda.getProduto())) {
                return "Produto não existe no banco.";
            }

            if (!vendaRepository.existsById(venda.getId())) {
                venda.setId(null == vendaRepository.findMaxId() ? 1 : vendaRepository.findMaxId() + 1);

                double precoUnitario = produtoService.getPrecoUnitarioPorNome(venda.getProduto());

                venda.setPrecoUnitario(precoUnitario);

                venda.setValorTotal(venda.getQuantidade() * venda.getPrecoUnitario());

                vendaRepository.save(venda);

                return "Venda cadastrada com sucesso.";
            } else {
                return "Venda já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Venda> readVenda() {
        return vendaRepository.findAll();
    }

    @Transactional
    public String updateVenda(Venda venda) {
        if (vendaRepository.existsById(venda.getId())) {
            try {
                Optional<Venda> vendaOptional = vendaRepository.findById(venda.getId());

                if (vendaOptional.isPresent()) {
                    Venda vendaToBeUpdate = vendaOptional.get();

                    if (!produtoService.existsByNome(venda.getProduto())) {
                        return "Produto não existe no banco.";
                    }

                    vendaToBeUpdate.setIdEmpresa(venda.getIdEmpresa());
                    vendaToBeUpdate.setIdCliente(venda.getIdCliente());
                    vendaToBeUpdate.setProduto(venda.getProduto());
                    vendaToBeUpdate.setQuantidade(venda.getQuantidade());

                    double precoUnitario = produtoService.getPrecoUnitarioPorNome(venda.getProduto());
                    vendaToBeUpdate.setPrecoUnitario(precoUnitario);
                    vendaToBeUpdate.setValorTotal(venda.getQuantidade() * precoUnitario);

                    vendaToBeUpdate.setPago(venda.getPago());

                    vendaRepository.save(vendaToBeUpdate);

                    return "Venda atualizada com sucesso.";
                } else {
                    return "Venda não encontrada no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Venda não existe no banco.";
        }
    }

    @Transactional
    public String deleteVenda(int id) {
        try {
            if (vendaRepository.existsById(id)) {
                vendaRepository.deleteById(id);
                return "venda deletada com sucesso.";
            } else {
                return "venda não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
