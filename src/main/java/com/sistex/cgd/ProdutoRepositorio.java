/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 *
 * @author jean
 */
@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long>{

    @Query("SELECT prod FROM Produto prod WHERE prod.nome like %:nome%")
    List<Produto> findAllByNome(@Param("nome") String nome);
}
