/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceangulajs.service;

import com.webserviceangulajs.Endereco;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 *
 * @author ariane
 */
@Path("/buscaEndereco")
public class EnderecoService {
    
        @Context
        Request request;    
    
//	@GET
//	@Path("/{param}")
//        @Produces("text/plain")
//	public Response getMsg(@PathParam("param") String cep) {
// 		String output = "Avenida joao pessoa : " + cep;
// 		return Response.status(200).entity(output).build();
// 	}
    
        
	@GET
	@Path("/{param}")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String cep) {
 		
                Endereco endereco = new Endereco();
                endereco.setBairro("Lauzane Paulista");
                endereco.setCep("02440050");
                endereco.setCidade("Sao Paulo");
                endereco.setEstado("SP");
                endereco.setRua("Avenida Joao Pessoa 408");
            
 		return Response.status(200).entity(endereco).build();
 	}
        
        
        
    
}
