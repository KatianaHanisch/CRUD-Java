package com.apicomsqlite.poo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

    public boolean existsById(int id);

    boolean existsByEmailAndIdNot(String email, int id);

    public Optional<Empregado> findById(int id);

    public List<Empregado> findByEmail(String email);

    @Query("select max(s.id) from Empregado s")
    public Integer findMaxId();
}