/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.util;

import com.sistex.cdp.Cliente;
import com.sistex.util.Fabrica;

/**
 *
 * @author jean
 */
class FabricaCliente extends Fabrica {

    @Override
    public Cliente criaCliente() {
        return new Cliente();
    }

}
