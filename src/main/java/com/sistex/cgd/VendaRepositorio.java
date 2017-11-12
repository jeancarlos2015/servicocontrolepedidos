/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Venda;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface VendaRepositorio extends CrudRepository<Venda, Long>{
    @Query("SELECT ve FROM Venda ve WHERE ve.nomeproduto like %:nomeproduto%")
    List<Venda> findAllByNomeProduto(@Param("nomeproduto") String nomeproduto);
    
    @Modifying
    @Query("UPDATE Venda ve SET ve.nomeproduto = :nomeproduto, "
            + "ve.quantidade = :quantidade, "
            + "ve.marcaproduto = :marcaproduto, "
            + "ve.precounidade = :precounidade"
            + " WHERE ve.id = :id")
    void update(@Param("nomeproduto") String nomeproduto,
            @Param("quantidade") Integer quantidade,
            @Param("marcaproduto") String marcaProduto,
            @Param("precounidade") Float precoUnidade,
            @Param("id") Long id);
}
