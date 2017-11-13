/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Pedido;
import com.sistex.cgt.PedidoServico;
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
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoServico pedidoService;

    @Autowired
    public void setPedidoService(PedidoServico pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        pedidoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Pedido alterar(@PathVariable("id") Long id, @RequestBody Pedido pedido) {
        pedido.setIdpedido(id);
        return pedidoService.update(pedido);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Pedido buscarPedido(@PathVariable("id") Long id) {
        return pedidoService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Pedido> listPedidos() {
        return pedidoService.listAll();
    }

    @RequestMapping(value = "/{datapedido}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Pedido> listPedidosDataPedido(@PathVariable("datapedido") String dataPedido) {
        return pedidoService.findAllByDatapedido(dataPedido);
    }
}
