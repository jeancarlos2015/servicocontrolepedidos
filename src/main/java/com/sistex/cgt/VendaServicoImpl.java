/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Venda;
import com.sistex.cgd.VendaRepositorio;
import com.sistex.util.Fabrica;
import com.sistex.util.Tipo;
import static com.sistex.util.Tipo.VENDA;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class VendaServicoImpl implements VendaServico{
    @Autowired
    private VendaRepositorio vendaRepositorio;
    private Fabrica fabrica = Fabrica.make(VENDA);
    @Override
    public List<Venda> listAll() {
        List<Venda> vendas = new ArrayList<>();
        vendaRepositorio.findAll().forEach(vendas::add);
        return vendas;
    }

    @Override
    public Venda getById(Long id) {
        return vendaRepositorio.findOne(id);
    }

  
    @Override
    public Venda update(Venda venda) {
       if(exist(venda.getIdvenda())){
           return vendaRepositorio.save(venda);
       }
       return fabrica.criaVenda();
    }

    @Override
    public void delete(Long id) {
        if(vendaRepositorio.exists(id)){
            vendaRepositorio.delete(id);
        }
    }

    @Override
    public Venda save(Venda venda) {
        return vendaRepositorio.save(venda);
    }

    @Override
    public List<Venda> findAllByNomeProduto(String nomeproduto) {
        List<Venda> vendas = new ArrayList<>();
        vendaRepositorio.findAllByNomeProduto(nomeproduto).forEach(vendas::add);
        return vendas;
    }

    @Override
    public boolean exist(Long id) {
        return vendaRepositorio.exists(id);
    }
    
}
