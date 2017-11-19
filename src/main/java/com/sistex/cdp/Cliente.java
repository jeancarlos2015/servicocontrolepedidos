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
public class Cliente{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
    protected String nome="";

    protected String telefone="";

    protected String email="";

    protected String endereco="";

    protected String datanascimento="";
    private String cpf;

    /**
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     */
    public Long getIdcliente() {
        return idcliente;
    }

    /**
     *
     * @param idcliente
     */
    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }
    
    
    public boolean isEmpty(){
        return nome.equals("") || 
                telefone.equals("") ||
                email.equals("") ||
                endereco.equals("") ||
                datanascimento.equals("") ||
                cpf.equals("");
    }
}
