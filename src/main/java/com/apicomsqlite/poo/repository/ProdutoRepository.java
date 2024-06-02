package com.apicomsqlite.poo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public boolean existsById(int id);

    public Optional<Produto> findById(int id);

    @Query("select max(s.id) from Produto s")
    public Integer findMaxId();
}