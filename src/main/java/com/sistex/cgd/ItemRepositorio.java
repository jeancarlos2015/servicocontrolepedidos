/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public interface ItemRepositorio extends CrudRepository<Item, Long> {

	 @Modifying
	    @Query("update Item i set i.nome = :nome, "
	            + "i.preco = :preco,"
	            + "i.quantidade = :quantidade,"
	            + "i.descricao = :descricao,"
	            + "i.categoria = :categoria,"
	            + "i.marca = :marca"
	            + " where i.id = :id")
	    void update(@Param("nome") String nome,
	            @Param("preco") Float preco,
	            @Param("quantidade") Integer quantidade,
	            @Param("categoria") String categoria,
	            @Param("marca") String marca,
	            @Param("descricao") String descricao,
	            @Param("id") Long id);

    @Query("SELECT item FROM Item item WHERE item.nome like %:nome% or item.marca like %:nome%")
    List<Item> findAllByNome(@Param("nome") String nome);
}
