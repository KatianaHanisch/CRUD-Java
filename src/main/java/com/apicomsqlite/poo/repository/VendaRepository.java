package com.apicomsqlite.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.apicomsqlite.poo.enity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    public boolean existsById(int id);

    public Optional<Venda> findById(int id);

    @Query("select max(s.id) from Venda s")
    public Integer findMaxId();
}