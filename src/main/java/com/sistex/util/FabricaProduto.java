/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Produto;

/**
 *
 * @author jean
 */
class FabricaProduto extends Fabrica {

    public FabricaProduto() {
    }

    @Override
    public Produto criaProduto(){
        return new Produto();
    }
    
}
