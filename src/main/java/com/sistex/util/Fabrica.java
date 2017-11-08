/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Item;
import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;

/**
 *
 * @author jean
 */
public class Fabrica {
    public static Fabrica make(Tipo tipo){
        switch(tipo){
            case PEDIDO:
                return new FabricaPedido();
            case PRODUTO:
                return new FabricaProduto();
            case ITEM:
                return new FabricaItem();
            default:
                return new Fabrica();
        }
    }
    
    public Item criaItem(){
        return null;
    }
    
    public Produto criaProduto(){
        return null;
    }
    public Pedido criaPedido(){
        return null;
    }
}
