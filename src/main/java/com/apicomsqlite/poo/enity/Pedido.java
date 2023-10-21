package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Pedido {

    @Id
    private int id;

    private String dataEmissao;
    private String dataFinalizacao;
    private double preco;
    private String tipo;
    private String gerenteResponsavel;
    private String vendedorResponsavel;
    private String producaoResponsavel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(String gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public String getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    public void setVendedorResponsavel(String vendedorResponsavel) {
        this.vendedorResponsavel = vendedorResponsavel;
    }

    public String getProducaoResponsavel() {
        return producaoResponsavel;
    }

    public void setProducaoResponsavel(String producaoResponsavel) {
        this.producaoResponsavel = producaoResponsavel;
    }
}
