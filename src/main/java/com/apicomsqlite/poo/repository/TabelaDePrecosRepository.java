package com.apicomsqlite.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.apicomsqlite.poo.enity.TabelaDePrecos;

@Repository
public interface TabelaDePrecosRepository extends JpaRepository<TabelaDePrecos, Integer> {

    public boolean existsById(int id);

    public Optional<TabelaDePrecos> findById(int id);

    @Query("select max(s.id) from TabelaDePrecos s")
    public Integer findMaxId();
}