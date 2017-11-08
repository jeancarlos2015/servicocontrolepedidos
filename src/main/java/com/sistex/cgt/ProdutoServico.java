/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Produto;
import java.util.List;



/**
 *
 * @author jean
 */
public interface ProdutoServico {

    List<Produto> listAll();

    Produto getById(Long id);

    Produto save(Produto produto);

    void delete(Long id);

    Produto update(Produto produto);

    List<Produto> findAllByNome(String nome);
}
