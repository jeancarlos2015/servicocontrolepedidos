/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Item;

/**
 *
 * @author jean
 */
class FabricaItem extends Fabrica {

    public FabricaItem() {
    }

    @Override
    public Item criaItem(){
        return new Item();
    }
    
}
