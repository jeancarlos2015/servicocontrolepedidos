/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Pedido;
import com.sistex.cgt.PedidoServico;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.PEDIDO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
@Controller
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServico pedidoService;

    private Fabrica fabrica  = Fabrica.make(PEDIDO);
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Boolean excluir(@PathVariable("id") Long id) {
        pedidoService.delete(id);
        return !pedidoService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    public Pedido alterar(@RequestBody Pedido pedido) {
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

    @RequestMapping(value = "/listaratuais/{status}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Pedido> listPedidosDataPedido(@PathVariable("status") String status) {
        return pedidoService.findAllByDataAtual(status);
    }
    
    @RequestMapping(value = "/listar/id/{idcliente}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Pedido> listPedidosIdCliente(@PathVariable("idcliente") Long idcliente) {
        return pedidoService.findAllByIdCliente(idcliente);
    }
    
    @RequestMapping(value = "/listar/{cpf}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Pedido> listPedidosCpf(@PathVariable("cpf") String cpf) {
        return pedidoService.findAllByCpf(cpf);
    }
}
