package com.apicomsqlite.poo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public boolean existsByCpf(String cpf);

    public Optional<Cliente> findByCpf(String cpf);

    public boolean existsById(int id);

    public Optional<Cliente> findById(int id);

    @Query("select max(s.id) from Cliente s")
    public Integer findMaxId();
}