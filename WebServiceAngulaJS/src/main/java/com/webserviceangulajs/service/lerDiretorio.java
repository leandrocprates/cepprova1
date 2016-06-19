/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceangulajs.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST Web Service
 *
 * @author lprates
 */
@Path("/lerDiretorio")
public class lerDiretorio {

    @Context
    private UriInfo context;

    public lerDiretorio() {
    }

    @GET
    public void getXml() {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream("script");
        BufferedReader buffer= new BufferedReader(new InputStreamReader(inStream));
        String linha;
        try{
            while ( (linha = buffer.readLine()) != null ){ 
                System.out.println(linha);
            }
            
        }catch(Exception ex){        
            System.out.println(ex);
        }
    }
    
    
    @GET
    @Path("/buscaListaString")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBuscaListaString(){
        
        List<String> list =null;
        GenericEntity<List<String>> entity=null;
        Response response;
        
        try{

            System.out.println("Comecando download Arquivo.");
            
            list = new ArrayList<String>();
            list.add("Primeiro");
            list.add("Segundo");

            entity = new GenericEntity<List<String>>(list){};
            response = Response.ok().entity(entity).build();            
            
        }catch(Exception ex){
            throw new WebApplicationException(404);
        }
        
        return response; 
                
    }

    
    @GET
    @Path("/buscaUnicaString")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getBuscaUnicaString(){
        
        GenericEntity<String> entity=null;
        Response response;
        
        try{

            System.out.println("Comecando download Arquivo.");
            entity = new GenericEntity<String>("Teste 2"){};
            response = Response.ok().entity(entity).build();            
            
        }catch(Exception ex){
            throw new WebApplicationException(404);
        }
        
        return response; 
                
    }
    
    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile() {

            //File file = new File("C:/Users/lprates/Documents/NetBeansProjects/WebServiceAngulaJS/src/main/resources/script/script.properties");

            File file = new File("C:/Users/lprates/Documents/NetBeansProjects/WebServiceAngulaJS/src/main/resources/script/excel.xlsx");
            ResponseBuilder response = Response.ok((Object) file);
            response.header("Content-Disposition",
                    "attachment; filename=excel.xlsx");
            return response.build();

    }
    
    
}
