/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Cliente;
import com.sistex.cgd.ClienteRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.CLIENTE;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class ClienteServicoImpl implements ClienteServico {

    private final Fabrica fabrica = Fabrica.make(CLIENTE);
    private final ClienteRepositorio clienteRepositorio;

    @Autowired
    public ClienteServicoImpl(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public List<Cliente> listAll() {
        List<Cliente> clientes = new ArrayList<>();
        clienteRepositorio.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Cliente getById(Long id) {
        return clienteRepositorio.findOne(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (!clienteRepositorio.exist(cliente.getCpf()) && !cliente.isEmpty()) {
            return clienteRepositorio.save(cliente);
        }
        return fabrica.criaCliente();

    }

    @Override
    public void delete(Long id) {
        if (clienteRepositorio.exists(id)) {
            clienteRepositorio.delete(id);
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        if (clienteRepositorio.exist(cliente.getCpf()) && !cliente.isEmpty()) {
            return clienteRepositorio.save(cliente);
        }
        return fabrica.criaCliente();
    }

    @Override
    public Cliente getByCpf(String cpf) {
        if(clienteRepositorio.exist(cpf)){
            return clienteRepositorio.findByCpf(cpf);
        }
        return fabrica.criaCliente();
    }

    @Override
    public List<Cliente> findAllByNome(String nome) {
        return clienteRepositorio.findAllByNome(nome);
    }

    @Override
    public boolean exist(Long id) {
        return clienteRepositorio.exists(id);
    }

    @Override
    public boolean exist(String cpf) {
        return clienteRepositorio.exist(cpf);
    }

}
