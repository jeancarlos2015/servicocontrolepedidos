/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Pedido;
import com.sistex.cgd.PedidoRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.PEDIDO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class PedidoServicoImpl implements PedidoServico {

    private final Fabrica fabrica = Fabrica.make(PEDIDO);
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    
    @Override
    public List<Pedido> listAll() {
        List<Pedido> lista = new ArrayList<>();
        pedidoRepositorio.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Pedido getById(Long id) {
        return pedidoRepositorio.findOne(id);
    }

    @Override
    public Pedido save(Pedido pedido) {

        return pedidoRepositorio.save(pedido);

    }

    @Override
    public void delete(Long id) {
        if (pedidoRepositorio.exists(id)) {
            pedidoRepositorio.delete(id);
        }
    }

    @Override
    public Pedido update(Pedido pedido) {
        if (pedidoRepositorio.exists(pedido.getIdpedido())) {
            pedidoRepositorio.update(pedido.getDatapedido(), pedido.getPrecototal(), pedido.getStatus(), pedido.getIdpedido());
            return pedidoRepositorio.findOne(pedido.getIdpedido());
        }
        return fabrica.criaPedido();
    }

    @Override
    public List<Pedido> findAllByDatapedido(String dataPedido) {
        return pedidoRepositorio.findAllByDatapedido(dataPedido);
    }

    /**
     * @param pedidoRepositorio the pedidoRepositorio to set
     */
}
