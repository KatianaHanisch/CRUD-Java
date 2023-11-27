package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class DadosLogin {

    @Id
    private String senha;
    private String email;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
