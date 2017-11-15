/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Item;
import java.util.List;

/**
 *
 * @author jean
 */
public interface ItemServico {
    List<Item> listAll();

    Item getById(Long id);

    Item save(Item item);

    void delete(Long id);

    Item update(Item item);

    List<Item> findAllByStatus(String status);
    
    boolean exist(Long id);
}
