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

    public boolean existsByNome(String nome);

    public Optional<Produto> findByNome(String nome);

    @Query("select max(s.id) from Produto s")
    public Integer findMaxId();
}