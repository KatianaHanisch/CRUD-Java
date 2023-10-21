package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;

@Entity

public class Terceirizado extends Usuario {

    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
