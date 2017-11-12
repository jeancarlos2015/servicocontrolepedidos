/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Venda;
import com.sistex.util.Fabrica;

/**
 *
 * @author jean
 */
class FabricaVenda extends Fabrica {

    public FabricaVenda() {
    }

   public Venda criaVenda(){
       return new Venda();
   }
    
}
