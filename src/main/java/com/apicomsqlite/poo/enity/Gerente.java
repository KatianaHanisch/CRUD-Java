package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;

@Entity

public class Gerente extends Usuario {

    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}
