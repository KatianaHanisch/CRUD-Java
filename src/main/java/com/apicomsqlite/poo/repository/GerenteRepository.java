package com.apicomsqlite.poo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

    public boolean existsById(int id);

    boolean existsByEmailAndIdNot(String email, int id);

    public Optional<Gerente> findById(int id);

    public List<Gerente> findByEmail(String email);

    @Query("select max(s.id) from Gerente s")
    public Integer findMaxId();
}