/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Produto;
import com.sistex.cgt.ProdutoServico;
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
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoServico produtoService;

    @Autowired
    public void setProdutoService(ProdutoServico produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable("id") Long id) {
        produtoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Produto alterar(@PathVariable("id") Long id, @RequestBody Produto produto) {
        produto.setIdproduto(id);
        return produtoService.update(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Produto buscarProduto(@PathVariable("id") Long id) {
        return produtoService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> listProdutos() {
        return produtoService.listAll();
    }

    @RequestMapping(value = "/{nome}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Produto> listProdutosNome(@PathVariable("nome") String nome) {
        return produtoService.findAllByNome(nome);
    }
}
