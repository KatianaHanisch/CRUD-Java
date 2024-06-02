package com.apicomsqlite.poo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    public boolean existsById(int id);

    public Optional<Empresa> findById(int id);

    @Query("select max(s.id) from Empresa s")
    public Integer findMaxId();
}