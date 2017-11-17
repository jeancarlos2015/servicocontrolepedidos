/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Item;
import com.sistex.cgd.ItemRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.ITEM;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class ItemServicoImpl implements ItemServico {

    private final Fabrica fabrica = Fabrica.make(ITEM);
    @Autowired
    private ItemRepositorio itemRepositorio;


    @Override
    public List<Item> listAll() {
        List<Item> lista = new ArrayList<>();

        itemRepositorio.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Item getById(Long id) {
        return itemRepositorio.findOne(id);
    }

    @Override
    public Item save(Item item) {

        return itemRepositorio.save(item);

    }

    @Override
    public void delete(Long id) {
        if (itemRepositorio.exists(id)) {
            itemRepositorio.delete(id);
        }
    }

    @Override
    public Item update(Item item) {
        if (itemRepositorio.exists(item.getIditem())) {
            return itemRepositorio.save(item);
        }
        return fabrica.criaItem();
    }

    @Override
    public List<Item> findAllByStatus(String status) {
        return itemRepositorio.findAllByNome(status);
    }

    @Override
    public boolean exist(Long id) {
        return itemRepositorio.exists(id);
    }
}
