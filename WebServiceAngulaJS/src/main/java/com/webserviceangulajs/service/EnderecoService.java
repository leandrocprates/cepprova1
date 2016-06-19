/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceangulajs.service;

import com.webserviceangulajs.Endereco;
import com.webserviceangulajs.RangesValidos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


/**
 * Rua Olimpíadas, 360 Vila Olimpia -           CEP: 04551000 - 04551500 - 04551999   São Paulo - SP.
 * Travessa Casalbuono nº 120  Vila Guilherme - CEP: 02089000 - 02089900 - 02089999   São Paulo / SP
 * Endereço: Rua Dr. Melo Freire S/N, Tatuapé   CEP: 03314000 - 03314030 - 03314999
 * 
 * @author ariane
 */



@Path("/buscaEndereco")
public class EnderecoService {
    
        @Context
        Request request;   
        
        
        static List<RangesValidos> listaDeRangesValidos = new ArrayList<RangesValidos>(); 
        static HashMap mapDeEnderecos = new HashMap<Integer, Endereco>(); 
    
//	@GET
//	@Path("/{param}")
//        @Produces("text/plain")
//	public Response getMsg(@PathParam("param") String cep) {
// 		String output = "Avenida joao pessoa : " + cep;
// 		return Response.status(200).entity(output).build();
// 	}
    
        
        static {
            
            RangesValidos range1 = new RangesValidos();
            range1.setRangeInicial(4551000);
            range1.setRangeFinal(4551999);
            
            RangesValidos range2 = new RangesValidos();
            range2.setRangeInicial(2089000);
            range2.setRangeFinal(2089999);
            
            RangesValidos range3 = new RangesValidos();
            range3.setRangeInicial(3314000);
            range3.setRangeFinal(3314999);

            listaDeRangesValidos.add(range1);
            listaDeRangesValidos.add(range2);
            listaDeRangesValidos.add(range3);
            
        }
        
        
        static {
            
            Endereco endereco1 = new Endereco();
            endereco1.setBairro("Vila Olimpia");
            endereco1.setCep("04551500");
            endereco1.setCidade("Sao Paulo");
            endereco1.setEstado("SP");
            endereco1.setRua("Rua Olimpíadas, 360");
            
            mapDeEnderecos.put(4551500,endereco1 );
            
            Endereco endereco2 = new Endereco();
            endereco2.setBairro("Vila Guilherme");
            endereco2.setCep("02089900");
            endereco2.setCidade("Sao Paulo");
            endereco2.setEstado("SP");
            endereco2.setRua("Travessa Casalbuono, 120");

            mapDeEnderecos.put(2089900,endereco2 );
            
            Endereco endereco3 = new Endereco();
            endereco3.setBairro("Tatuapé");
            endereco3.setCep("03314030");
            endereco3.setCidade("Sao Paulo");
            endereco3.setEstado("SP");
            endereco3.setRua("Dr. Melo Freire S/N");

            mapDeEnderecos.put(3314030,endereco3 );
            
        }
        
        
        
        
	@GET
	@Path("/{param}")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String cep) {
            
                Endereco endereco = new Endereco();
                boolean cepValido=false ; 
            
                for (  RangesValidos range :  listaDeRangesValidos ) {
                    
                    if ( Integer.parseInt(cep) >=  range.getRangeInicial() &&   
                         Integer.parseInt(cep) <=  range.getRangeFinal()        ){
                        
                        cepValido=true; 
                    }
                    
                }
                
                if ( cepValido == false  ){
                    endereco.setMsg("Cep invalido");
                    return Response.status(404).entity(endereco).build();
                }
            
                
                //endereco.setBairro("Lauzane Paulista");
                //endereco.setCep("02440050");
                //endereco.setCidade("Sao Paulo");
                //endereco.setEstado("SP");
                //endereco.setRua("Avenida Joao Pessoa 408");
            
                
                endereco =  (Endereco) mapDeEnderecos.get(Integer.parseInt(cep)); 
                
                
                
 		return Response.status(200).entity(endereco).build();
 	
        }
        
        
        
    
}
