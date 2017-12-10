/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */

public interface PedidoRepositorio extends CrudRepository<Pedido, Long>{
  

    @Query("SELECT pedido FROM Pedido pedido WHERE pedido.datapedido like %:datapedido%")
    List<Pedido> findAllByDatapedido(@Param("datapedido") String datapedido);
    
    @Query("SELECT pedido FROM Pedido pedido WHERE pedido.idcliente = :idcliente")
    List<Pedido> findAllByIdCliente(@Param("idcliente") Long idcliente);
    
    
    @Query("SELECT pedido FROM Pedido pedido WHERE pedido.cpf = :cpf")
    List<Pedido> findAllByCpf(@Param("cpf") String cpf);
}
