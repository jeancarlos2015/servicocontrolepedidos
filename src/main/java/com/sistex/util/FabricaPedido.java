/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Pedido;

/**
 *
 * @author jean
 */
class FabricaPedido extends Fabrica {

    public FabricaPedido() {
    }
    
    @Override
    public Pedido criaPedido(){
        return new Pedido();
    }
    
}
