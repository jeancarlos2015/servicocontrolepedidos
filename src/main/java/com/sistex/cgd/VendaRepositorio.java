/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Venda;
import java.util.List;
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
  
}
