/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface PedidoRepositorio extends CrudRepository<Pedido, Long>{
    @Modifying
    @Query("update Pedido pedido set pedido.datapedido = :datapedido, "
            + "pedido.precototal = :precototal,"
            + "pedido.status = :status"
            + " where pedido.id = :id")
    void update(@Param("datapedido") String datapedido,
            @Param("precototal") Float precototal,
            @Param("status") String status,
            @Param("id") Long id);

    @Query("SELECT pedido FROM Pedido pedido WHERE pedido.datapedido like %:datapedido%")
    List<Pedido> findAllByDatapedido(@Param("datapedido") String datapedido);
}
