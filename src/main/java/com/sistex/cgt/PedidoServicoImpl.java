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
    private String getDataAtual(){
        final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final Calendar cal = Calendar.getInstance();
        String datapedido = df.format(cal.getTime());
        return datapedido;
    }
    @Override
    public Pedido save(Pedido pedido) {
        
        pedido.setDatapedido(getDataAtual());
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
    public List<Pedido> findAllByDataAtual(String status) {
        return pedidoRepositorio.findAllByDatapedido(getDataAtual(),status);
    }

    @Override
    public boolean exist(Long id) {
        return pedidoRepositorio.exists(id);
    }

    @Override
    public List<Pedido> findAllByIdCliente(Long idCliente) {
        return pedidoRepositorio.findAllByIdCliente(idCliente);
    }

    @Override
    public List<Pedido> findAllByCpf(String cpf) {
        return pedidoRepositorio.findAllByCpf(cpf);
    }

    /**
     * @param pedidoRepositorio the pedidoRepositorio to set
     */
}
