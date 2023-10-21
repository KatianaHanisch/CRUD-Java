package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    public boolean existsById(int id);

    public List<Pedido> findById(int id);

    @Query("select max(s.id) from Pedido s")
    public Integer findMaxId();
}