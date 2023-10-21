package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

    public boolean existsByNome(String nome);

    public List<Gerente> findByNome(String nome);

    @Query("select max(s.id) from Gerente s")
    public Integer findMaxId();
}