/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Item;
import com.sistex.cgt.ItemServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jean
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    private ItemServico itemService;

    @Autowired
    public void setItemService(ItemServico itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        itemService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Item cadastrar(@RequestBody Item item) {
        return itemService.save(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Item alterar(@PathVariable("id") Long id, @RequestBody Item item) {
        item.setIditem(id);
        return itemService.update(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item buscarItem(@PathVariable("id") Long id) {
        return itemService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Item> listItems() {
        return itemService.listAll();
    }

    @RequestMapping(value = "/listar/{status}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Item> listItemsDataItem(@PathVariable("status") String status) {
        return itemService.findAllByStatus(status);
    }
}
