/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webserviceangulajs.service;

import com.webserviceangulajs.Registro;
import com.webserviceangulajs.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
 
@Path("/hello")
public class HelloWorldService {
    
        @Context
        Request request;    
    
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 		String output = "Jersey say : " + msg;
 		return Response.status(200).entity(output).build();
 	}
        
	@GET
	@Path("/getRegistro")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
 		Registro registro = new Registro();
                registro.setColuna("NCM");
                registro.setValor("103090");
                
                Usuario usuario = new Usuario();
                usuario.setNome("Leandro");
                usuario.setTelefone("22333018");
                registro.setUsuario(usuario);
                
 		return Response.status(200).entity(registro).build();
 	}
        
        @POST
        @Path("/addRegistro")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addRegistro(Registro registro){
            System.out.println("Coluna: "+registro.getColuna());
            System.out.println("Valor: "+registro.getValor());
            System.out.println("Usuario Nome: "+registro.getUsuario().getNome());
            System.out.println("Usuario Telefone: "+registro.getUsuario().getTelefone());
            
            return Response.status(200).build();
        }

        
        @DELETE
        @Path("/deleteRegistro")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteRegistro(Registro registro){
            System.out.println("Coluna: "+registro.getColuna());
            System.out.println("Valor: "+registro.getValor());
            System.out.println("Usuario Nome: "+registro.getUsuario().getNome());
            System.out.println("Usuario Telefone: "+registro.getUsuario().getTelefone());
            
            return Response.status(200).build();
        }
        
        
        @POST
        @Path("/addStringJson")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addRegistroViaJson(String mensagem){
            System.out.println("======== Recebido via Json ======== ");
            System.out.println("Mensagem: "+ mensagem);
            return Response.status(200).build();
        }

        @POST
        @Path("/addStringText")
        @Consumes(MediaType.TEXT_PLAIN)
        public Response addRegistroViaText(String mensagem){
            System.out.println("======== Recebido via Text Plain ======== ");
            System.out.println("Mensagem: "+ mensagem);
            return Response.status(200).build();
        }
        
        @POST
        @Path("/addStringPostForm")
        @Consumes("application/x-www-form-urlencoded")
        public Response addStringPostForm(@FormParam("id") String id, @FormParam("nome") String nome){
            System.out.println("======== Recebido via Post Form ======== ");
            System.out.println("Id: "+ id);
            System.out.println("Nome: "+ nome);
            return Response.status(200).build();
        }
        
 
}