/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Produto;
import com.sistex.cgt.ProdutoServico;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private ProdutoServico produtoService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean excluir(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return !produtoService.exist(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean cadastrar(@RequestBody Produto produto) {
        Produto novo = produtoService.save(produto);
        return produtoService.exist(novo.getIdproduto());
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
    
    @RequestMapping(value="size/{tam}", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> listProdutosCount(@PathVariable("tam") Integer tam) {
        List<Produto> resultList = new ArrayList<>();
        for(Produto produto:produtoService.listAll()){
            resultList.add(produto);
            if(tam==0){
                break;
            }
            tam--;
        }
        return resultList;
    }
    @RequestMapping(value = "/listar/{nome}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Produto> listProdutosNome(@PathVariable("nome") String nome) {
        return produtoService.findAllByNome(nome);
    }
}
