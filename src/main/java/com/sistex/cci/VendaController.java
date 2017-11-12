/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Venda;
import com.sistex.cgt.VendaServico;
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
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaServico vendaServico;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        vendaServico.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Venda cadastrar(@RequestBody Venda venda) {
        return vendaServico.save(venda);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Venda alterar(@PathVariable("id") Long id, @RequestBody Venda venda) {
        venda.setIdvenda(id);
        return vendaServico.update(venda);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Venda buscarVenda(@PathVariable("id") String id) {
        return vendaServico.getById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Venda> listVendas() {
        return vendaServico.listAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
    @ResponseBody
    public List<Venda> listVendaesNome(@PathVariable("nome") String nome) {
        return vendaServico.findAllByNomeProduto(nome);
    }
}
