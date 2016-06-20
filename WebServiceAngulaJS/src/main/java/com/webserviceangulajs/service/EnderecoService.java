/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceangulajs.service;

import com.webserviceangulajs.Endereco;
import com.webserviceangulajs.RangesValidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
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
 * Endereço: Rua Dr. Melo Freire S/N, Tatuapé   CEP: 03314000 - 03314030 - 03314999   São Paulo / SP
 * Avenic Nova Cantareira                       CEP: 02514000 -          - 02514999   São Paulo / SP
 * @author ariane
 */



@Path("/buscaEndereco")
public class EnderecoService {
    
        @Context
        Request request;   
        
        
        /* Mapa de Enderecos carregados na memoria. */
        static HashMap mapDeEnderecos = new HashMap<Integer, Endereco>(); 
    
        /* ID dos enderecos cadastrado , Simula Primary Key do Banco de dados. */
        static int idEndereco = 1 ; 
        
        
        static {
            
            Endereco endereco1 = new Endereco();
            endereco1.setId(idEndereco);
            endereco1.setBairro("Vila Olimpia");
            endereco1.setCep("04551500");
            endereco1.setCidade("Sao Paulo");
            endereco1.setEstado("SP");
            endereco1.setRua("Rua Olimpíadas");
            endereco1.setNumero(360);
            
            mapDeEnderecos.put(idEndereco,endereco1 );
            
            idEndereco++;
            
            Endereco endereco2 = new Endereco();
            endereco2.setId(idEndereco);
            endereco2.setBairro("Vila Guilherme");
            endereco2.setCep("02089900");
            endereco2.setCidade("Sao Paulo");
            endereco2.setEstado("SP");
            endereco2.setRua("Travessa Casalbuono");
            endereco2.setNumero(120);

            mapDeEnderecos.put(idEndereco,endereco2 );
            
            idEndereco++;
            
            Endereco endereco3 = new Endereco();
            endereco3.setId(idEndereco);
            endereco3.setBairro("Tatuapé");
            endereco3.setCep("03314030");
            endereco3.setCidade("Sao Paulo");
            endereco3.setEstado("SP");
            endereco3.setRua("Dr. Melo Freire ");
            endereco3.setNumero(50);

            mapDeEnderecos.put(idEndereco,endereco3 );
            
            idEndereco++;
            
            Endereco endereco4 = new Endereco();
            endereco4.setId(idEndereco);
            endereco4.setBairro("Cantareira");
            endereco4.setCep("02514000");
            endereco4.setCidade("Sao Paulo");
            endereco4.setEstado("SP");
            endereco4.setRua("Avenida Nova Cantareira");
            endereco4.setNumero(3500);
            
            mapDeEnderecos.put(idEndereco,endereco4 );
            
        }
        
        
        /**
         * Funcao responsavel pela consulta do CEP
         * @param cep CEP para buscar no map mapDeEnderecos
         * @return 
         */
        
	@GET
	@Path("/{param}")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String cep) {
            
                Endereco endereco = new Endereco();
                boolean cepValido=false ; 
            
                
                
                if ( validaCep(cep) == false  ){
                    endereco.setMsg("Cep invalido");
                    return Response.status(404).entity(endereco).build();
                }
            
                
                
                //Acha na primeira tentativa caso diferente de null
                endereco = buscaCep( cep.toCharArray() ); 
                
                
                int lastIndex = cep.length()-1;
                int countMaxBusca = 0; //Tenta buscar somente substituindo os ultimos 3 digitos por 0 
                
                
                while ( endereco == null && countMaxBusca < 3  ){
                    
                    char cepArray [] = cep.toCharArray(); 
                    cepArray[lastIndex]='0';
                    
                    endereco = buscaCep( cepArray ); 
                    
                    
                    lastIndex = lastIndex-1; 
                    countMaxBusca++; 
                    cep =  String.valueOf(cepArray); 
                    
                }
                
                
 		return Response.status(200).entity(endereco).build();
 	
        }
        
        
        /**
         * Funcao responsavel pela adição de novo Endereco
         * @param endereco Recebe o endereco para adicionar ou atualizar 
         * @return 
         */
        @POST
        @Path("/addEndereco")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addEndereco(Endereco  endereco){
            
            System.out.println("ID: "+ endereco.getId());
            System.out.println("CEP: "+ endereco.getCep());
            System.out.println("RUA: "+ endereco.getRua());
            System.out.println("BAirro: "+endereco.getBairro());
            System.out.println("Cidade: "+endereco.getCidade());
            System.out.println("Numero: "+endereco.getNumero());
            

            String replacedCep = endereco.getCep().replaceAll("-", "");
            
            
            
            // Se ID > 0 Atualiza , senao insere novo 
            if ( endereco.getId() > 0  ){
                mapDeEnderecos.put( endereco.getId() , endereco );
            } else {
                idEndereco++;
                endereco.setId(idEndereco);
                mapDeEnderecos.put( idEndereco , endereco );
            }
            
            
            return Response.status(200).build();
        }
        
        /**
         * Funcao responsavel por listar todos os Enderecos cadastrados
         * @return 
         */
	@GET
	@Path("/listarEnderecos")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getListaEnderecos() {
            
            
            Collection<Endereco>  collectionEndereco =   mapDeEnderecos.values(); 

            GenericEntity<Collection<Endereco>> entity = new GenericEntity<Collection<Endereco>>(collectionEndereco) {};
            return Response.ok().entity(entity).build();            
            
        }
        

        /**
         * Funcao responsavel por deletar Endereco cadastrado
         * @param endereco Endereco a ser excluido
         * @return 
         */
        @DELETE
        @Path("/excluirEndereco")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteRegistro(Endereco  endereco){
            
            System.out.println("ID: "+ endereco.getId());
            System.out.println("CEP: "+ endereco.getCep());
            System.out.println("RUA: "+ endereco.getRua());
            System.out.println("Bairro: "+endereco.getBairro());
            System.out.println("Cidade: "+endereco.getCidade());
            System.out.println("Numero: "+endereco.getNumero());
            
            mapDeEnderecos.remove(endereco.getId()); 
            
            return Response.status(200).build();
            
        }
        
        /**
         * Busca cep por 04551999 , 04551990 , 04551900 ou 04551000
         * @param cepArray
         * @return 
         */
        public Endereco buscaCep(char cepArray []){
            
            Endereco enderecoRetorno = null; 
            
            Collection<Endereco>  collectionEndereco =  mapDeEnderecos.values(); 
            
            for (Endereco endereco : collectionEndereco ){
                
                if ( endereco.getCep().equals(String.valueOf(cepArray)) ) {
                    enderecoRetorno = endereco ; 
                    break; 
                }
                
            }
            
            return enderecoRetorno;
            
        }
        
        /**
         * Funcao responsavel por  validar o Cep
         * @param cep - CEP a ser validado
         * @return 
         */
        public boolean validaCep(String cep)
        {
            if (cep.length() == 8)
            {
                cep = cep.substring(0, 5) + "-" + cep.substring(5, 8);
                
            }
            Pattern pattern =  Pattern.compile("[0-9]{5}-[0-9]{3}");
            Matcher m = pattern.matcher(cep);
            return m.matches();            
        }        
        
}
