/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Venda;
import java.util.List;

/**
 *
 * @author jean
 */
public interface VendaServico {
    List<Venda> listAll();

    Venda getById(Long id);

    Venda getByRg(String rg);

    Venda update(Venda venda);

    void delete(Long id);

    Venda save(Venda venda);
    
    List<Venda> findAllByNome(String nome);
}
