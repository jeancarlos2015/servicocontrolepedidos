/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Pedido;
import java.util.List;


/**
 *
 * @author jean
 */
public interface PedidoServico {

    List<Pedido> listAll();

    Pedido getById(Long id);

    Pedido save(Pedido pedido);

    void delete(Long id);

    Pedido update(Pedido pedido);

    List<Pedido> findAllByDataAtual(String status);
    
    List<Pedido> findAllByIdCliente(Long idCliente);
    
    List<Pedido> findAllByCpf(String cpf);
    
    boolean exist(Long id);
}
