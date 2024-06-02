package com.apicomsqlite.poo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    public boolean existsByCpf(String cpf);

    public Optional<Funcionario> findByCpf(String cpf);

    public boolean existsById(int id);

    public Optional<Funcionario> findById(int id);

    @Query("select max(s.id) from Funcionario s")
    public Integer findMaxId();
}