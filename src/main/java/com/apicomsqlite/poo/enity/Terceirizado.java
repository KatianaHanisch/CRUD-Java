package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Terceirizado {

    @Id
    private int id;

    private String nome;
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}