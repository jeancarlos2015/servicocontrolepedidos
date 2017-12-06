/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Cliente;
import java.util.List;

/**
 *
 * @author jean
 */
public interface ClienteServico {

    List<Cliente> listAll();

    Cliente getById(Long id);

    Cliente getByCpf(String cpf);

    Cliente save(Cliente cliente);

    void delete(Long id);
    
    boolean exist(Long id);
    
    boolean exist(String cpf);
    
    Cliente update(Cliente cliente);

    List<Cliente> findAllByNome(String nome);

}
