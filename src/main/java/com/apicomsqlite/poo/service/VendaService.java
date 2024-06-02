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

    @Transactional
    public String createVenda(Venda venda) {
        try {
            if (!vendaRepository.existsById(venda.getId())) {
                venda.setId(null == vendaRepository.findMaxId() ? 1 : vendaRepository.findMaxId() + 1);
                vendaRepository.save(venda);

                return "Vedido cadastrada com sucesso.";
            } else {
                return "Vedido já existe no banco.";
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

                    if (!vendaRepository.existsById(venda.getId())) {

                        vendaToBeUpdate.setIdEmpresa(venda.getIdEmpresa());
                        vendaToBeUpdate.setIdCliente(venda.getIdCliente());
                        vendaToBeUpdate.setProduto(venda.getProduto());
                        vendaToBeUpdate.setQuantidade(venda.getQuantidade());
                        vendaToBeUpdate.setValorTotal(venda.getValorTotal());
                        vendaToBeUpdate.setPago(venda.getPago());

                        vendaRepository.save(vendaToBeUpdate);

                        return "venda atualizado com sucesso.";
                    } else {
                        return "Já existe um venda com o id fornecido.";
                    }
                } else {
                    return "venda não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "venda não existe no banco.";
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
