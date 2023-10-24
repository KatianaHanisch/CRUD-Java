package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Producao;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Integer> {

    public boolean existsById(int id);

    public List<Producao> findById(int id);

    @Query("select max(s.id) from Producao s")
    public Integer findMaxId();
}