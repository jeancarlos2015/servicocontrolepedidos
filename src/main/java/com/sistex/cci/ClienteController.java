/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Cliente;
import com.sistex.cgt.ClienteServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jean
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServico clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Boolean excluir(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return clienteService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean cadastrar(@RequestBody Cliente cliente) {
        Cliente novo = clienteService.save(cliente);
        return clienteService.exist(novo.getIdcliente());
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    public Cliente alterar(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cliente buscarCliente(@PathVariable("id") Long id) {
        return clienteService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Cliente> listClientes() {
        return clienteService.listAll();
    }

    @RequestMapping(value = "/listar/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public List<Cliente> listClientesNome(@PathVariable("nome") String nome) {
        return clienteService.findAllByNome(nome);
    }

}
