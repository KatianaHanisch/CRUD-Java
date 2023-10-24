package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Terceirizado;

@Repository
public interface TerceirizadoRepository extends JpaRepository<Terceirizado, Integer> {

    public boolean existsById(int id);

    public List<Terceirizado> findById(int id);

    @Query("select max(s.id) from Terceirizado s")
    public Integer findMaxId();
}