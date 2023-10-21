package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Pedido;
import com.apicomsqlite.poo.repository.PedidoRepository;

// import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired(required = false)
    private PedidoRepository pedidoRepository;

    // @PersistenceContext

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
                List<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
                for (Pedido pedidoToBeUpdate : pedidos) {
                    pedidoToBeUpdate.setDataEmissao(pedido.getDataEmissao());
                    pedidoToBeUpdate.setDataFinalizacao(pedido.getDataFinalizacao());
                    pedidoToBeUpdate.setGerenteResponsavel(pedido.getGerenteResponsavel());
                    pedidoToBeUpdate.setVendedorResponsavel(pedido.getVendedorResponsavel());
                    pedidoToBeUpdate.setProducaoResponsavel(pedido.getProducaoResponsavel());
                    pedidoToBeUpdate.setTipo(pedido.getTipo());
                    pedidoToBeUpdate.setPreco(pedido.getPreco());
                    pedidoRepository.save(pedidoToBeUpdate);
                }
                return "Pedido atualizada.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Pedido não existe no banco.";
        }
    }

    @Transactional
    public String deletePedido(Pedido Pedido) {
        if (pedidoRepository.existsById(Pedido.getId())) {
            try {
                List<Pedido> Pedidos = pedidoRepository.findById(Pedido.getId());
                Pedidos.stream().forEach(s -> {
                    pedidoRepository.delete(s);
                });
                return "Pedido deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Pedido n\u00E3o existe no banco.";
        }
    }
}
