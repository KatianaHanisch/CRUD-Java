package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.TabelaDePrecos;

@Repository
public interface TabelaDePrecosRepository extends JpaRepository<TabelaDePrecos, Integer> {

    public boolean existsByTipo(String tipo);

    public List<TabelaDePrecos> findById(String tipo);

    @Query("select max(s.id) from TabelaDePrecos s")
    public Integer findMaxId();
}