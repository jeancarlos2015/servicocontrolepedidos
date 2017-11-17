/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public interface ItemRepositorio extends CrudRepository<Item, Long> {

    @Query("SELECT item FROM Item item WHERE item.nome like %:nome% or item.marca like %:nome%")
    List<Item> findAllByNome(@Param("nome") String nome);
}
