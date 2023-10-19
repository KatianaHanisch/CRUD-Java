package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

    public boolean existsById(int id);

    public List<Pedidos> findById(int id);

    @Query("select max(s.id) from Pedidos s")
    public Integer findMaxId();
}