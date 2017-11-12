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
    
   private String nomeproduto;
    private String marcaproduto;
    private Integer quantidade;
    private Float precounidade;

    public Long getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Long idvenda) {
        this.idvenda = idvenda;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getMarcaproduto() {
        return marcaproduto;
    }

    public void setMarcaproduto(String marcaproduto) {
        this.marcaproduto = marcaproduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPrecounidade() {
        return precounidade;
    }

    public void setPrecounidade(Float precounidade) {
        this.precounidade = precounidade;
    }

    

}
