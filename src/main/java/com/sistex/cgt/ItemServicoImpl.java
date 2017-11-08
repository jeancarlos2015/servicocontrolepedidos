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
    private ItemRepositorio itemRepositorio;

    @Autowired
    public void setItemRepositorio(ItemRepositorio itemRepositorio) {
        this.itemRepositorio = itemRepositorio;
    }

    @Override
    public List<Item> listAll() {
        List<Item> lista = new ArrayList();

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
            itemRepositorio.update(item.getCategoria(),
                    item.getMarca(),
                    item.getPreco(),
                    item.getIditem());
            return itemRepositorio.findOne(item.getIditem());
        }
        return fabrica.criaItem();
    }

    @Override
    public List<Item> findAllByStatus(String status) {
        return itemRepositorio.findAllByNome(status);
    }
}
