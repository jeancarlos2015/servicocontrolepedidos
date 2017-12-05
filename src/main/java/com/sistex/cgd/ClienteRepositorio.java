/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jean
 */
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    @Query("SELECT CASE WHEN COUNT(cli) > 0 THEN true ELSE false END FROM Cliente cli WHERE cli.cpf = :cpf")
    boolean exist(@Param("cpf") String cpf);

//    @Query("SELECT cli FROM Cliente cli WHERE cli.cpf = :cpf")
    Cliente findByCpf(@Param("cpf") String cpf);

//    @Query("SELECT cli FROM Cliente cli WHERE cli.nome like %:nome%")
    List<Cliente> findAllByNome(@Param("nome") String nome);

}
