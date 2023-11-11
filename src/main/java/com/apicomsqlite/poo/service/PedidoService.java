package com.apicomsqlite.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Pedido;
import com.apicomsqlite.poo.enity.TabelaDePrecos;
import com.apicomsqlite.poo.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired(required = false)
    private PedidoRepository pedidoRepository;

    @Transactional

    public String createPedido(Pedido pedido) {
        try {
            if (!pedidoRepository.existsById(pedido.getId())) {
                pedido.setId(null == pedidoRepository.findMaxId() ? 1 : pedidoRepository.findMaxId() + 1);
                pedidoRepository.save(pedido);

                return "Pedido cadastrada com sucesso.";
            } else {
                return "Pedido já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Pedido> readPedido() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public String updatePedido(Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getId())) {
            try {
                Optional<Pedido> listaPedidos = pedidoRepository.findById(pedido.getId());
                if (listaPedidos.isPresent()) {
                    Pedido pedidoToBeUpdate = listaPedidos.get();
                    pedidoToBeUpdate.setDataEmissao(pedido.getDataEmissao());
                    pedidoToBeUpdate.setDataFinalizacao(pedido.getDataFinalizacao());
                    pedidoToBeUpdate.setGerenteResponsavel(pedido.getGerenteResponsavel());
                    pedidoToBeUpdate.setVendedorResponsavel(pedido.getVendedorResponsavel());
                    pedidoToBeUpdate.setProducaoResponsavel(pedido.getProducaoResponsavel());
                    pedidoToBeUpdate.setTipo(pedido.getTipo());
                    pedidoToBeUpdate.setPreco(pedido.getPreco());
                    pedidoRepository.save(pedidoToBeUpdate);
                    return "Pedido atualizado.";
                } else {
                    return "Pedido não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Pedido não existe no banco.";
        }
    }

    @Transactional
    public String deletePedido(int id) {
        try {
            if (pedidoRepository.existsById(id)) {
                pedidoRepository.deleteById(id);
                return "Pedido deletado com sucesso.";
            } else {
                return "Pedido não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
