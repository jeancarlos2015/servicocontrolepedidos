/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import com.sistex.cdp.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 *
 * @author jean
 */
public interface ProdutoRepositorio extends CrudRepository<Produto, Long>{
    @Modifying
    @Query("update Produto prod set prod.nome = :nome, "
            + "prod.preco = :preco,"
            + "prod.quantidade = :quantidade,"
            + "prod.descricao = :descricao"
            + " where prod.id = :id")
    void update(@Param("nome") String nome,
            @Param("preco") Float preco,
            @Param("quantidade") Integer quantidade,
            @Param("descricao") String descricao,
            @Param("id") Long id);
    
    
  
    @Query("SELECT prod FROM Produto prod WHERE prod.nome like %:nome%")
    List<Produto> findAllByNome(@Param("nome") String nome);
}
