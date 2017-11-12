/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jean
 */
@Entity
public class Venda{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idvenda;
    private String nomeProduto;
    private String marca;
    private Float custoMensal;
    private Float totalVenda;
    private Integer qtVendas;

    public Integer getQtVendas() {
        return qtVendas;
    }

    public void setQtVendas(Integer qtVendas) {
        this.qtVendas = qtVendas;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
    

    public Long getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Long idvenda) {
        this.idvenda = idvenda;
    }

    

    public Float getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(Float custoMensal) {
        this.custoMensal = custoMensal;
    }

    public Float getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Float totalVenda) {
        this.totalVenda = totalVenda;
    }

   

}
