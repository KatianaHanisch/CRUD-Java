package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Terceirizado;

@Repository
public interface TerceirizadoRepository extends JpaRepository<Terceirizado, Integer> {

    public boolean existsByNome(String nome);

    public List<Terceirizado> findByNome(String nome);

    @Query("select max(s.id) from Terceirizado s")
    public Integer findMaxId();
}