/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Produto;
import com.sistex.cgd.ProdutoRepositorio;
import com.sistex.util.Fabrica;
import static com.sistex.util.Tipo.PRODUTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class ProdutoServicoImpl implements ProdutoServico {

    private final Fabrica fabrica = Fabrica.make(PRODUTO);
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    public void setProdutoRepositorio(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public List<Produto> listAll() {
        List<Produto> lista = new ArrayList();
        produtoRepositorio.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Produto getById(Long id) {
        return produtoRepositorio.findOne(id);
    }

    @Override
    public Produto save(Produto produto) {

        return produtoRepositorio.save(produto);

    }

    @Override
    public void delete(Long id) {
        if (produtoRepositorio.exists(id)) {
            produtoRepositorio.delete(id);
        }
    }

    @Override
    public Produto update(Produto produto) {
        if (produtoRepositorio.exists(produto.getIdproduto())) {
            produtoRepositorio.update(produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    produto.getDescricao(),
                    produto.getIdproduto());
            return produtoRepositorio.findOne(produto.getIdproduto());
        }
        return fabrica.criaProduto();
    }

    @Override
    public List<Produto> findAllByNome(String nome) {
        return produtoRepositorio.findAllByNome(nome);
    }

}