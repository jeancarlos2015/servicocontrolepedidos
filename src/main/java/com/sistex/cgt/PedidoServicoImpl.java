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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final Calendar cal = Calendar.getInstance();
        String datapedido = df.format(cal.getTime());
        pedido.setDatapedido(datapedido);
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
            return pedidoRepositorio.save(pedido);
        }
        return fabrica.criaPedido();
    }

    @Override
    public List<Pedido> findAllByDatapedido(String dataPedido) {
        return pedidoRepositorio.findAllByDatapedido(dataPedido);
    }

    @Override
    public boolean exist(Long id) {
        return pedidoRepositorio.exists(id);
    }

    /**
     * @param pedidoRepositorio the pedidoRepositorio to set
     */
}
