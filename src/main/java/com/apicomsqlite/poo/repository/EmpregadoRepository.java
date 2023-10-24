package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

    public boolean existsById(int id);

    public List<Empregado> findById(int id);

    @Query("select max(s.id) from Empregado s")
    public Integer findMaxId();
}