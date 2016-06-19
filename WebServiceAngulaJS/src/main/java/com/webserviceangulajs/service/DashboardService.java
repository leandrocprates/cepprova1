/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webserviceangulajs.service;

import com.webservice.graficos.C;
import com.webservice.graficos.Cols;
import com.webservice.graficos.ConsumoVO;
import com.webservice.graficos.Rows;

import com.google.gson.Gson;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Context;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author acer k
 */
@Path("dashboard")
public class DashboardService {

    private Logger logger = Logger.getLogger(DashboardService.class.getName());

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    
    @Path("/usuarios/consumo")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getConsumoUsuarios(){
        
        String jsonString=null;
        
        ConsumoVO consumo2 = new ConsumoVO();
        
        Cols cols1 = new Cols();
        cols1.setId("Nome");
        cols1.setLabel("Nome");
        cols1.setType("string");
        consumo2.setCols(cols1);
        
        Cols cols2 = new Cols();
        cols2.setId("Contador");
        cols2.setLabel("Contador");
        cols2.setType("number");
        consumo2.setCols(cols2);
        
        
        try{

            C coluna1 = new C();
            coluna1.setV("Leandro");

            C coluna2 = new C();
            coluna2.setV(5);

            Rows rows = new Rows();
            rows.setC(coluna1);
            rows.setC(coluna2);

            consumo2.setRows(rows);

            /*####*/

            C coluna3 = new C();
            coluna3.setV("Matui");

            C coluna4 = new C();
            coluna4.setV(15);

            Rows rows2 = new Rows();
            rows2.setC(coluna3);
            rows2.setC(coluna4);

            consumo2.setRows(rows2);
            
            /*####*/

            Gson gson = new Gson();
            jsonString = gson.toJson(consumo2);
            
        } catch(Exception e){
            logger.log(Level.SEVERE,"Error: {0} ", e );
        }
        
        return jsonString;
        
    }
    
    
    
    @Path("/usuarios/consumoMensal")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getConsumoPorMes(){
        
        String jsonString=null;
        
        ConsumoVO consumo2 = new ConsumoVO();
        
        Cols cols1 = new Cols();
        cols1.setId("Mes");
        cols1.setLabel("Mes");
        cols1.setType("string");
        consumo2.setCols(cols1);
        
        Cols cols2 = new Cols();
        cols2.setId("Quantidade Carregada");
        cols2.setLabel("Quantidade Carregada");
        cols2.setType("number");
        consumo2.setCols(cols2);
        
        
        try{

            C coluna1 = new C();
            coluna1.setV("07-2015");

            C coluna2 = new C();
            coluna2.setV(30);

            Rows rows = new Rows();
            rows.setC(coluna1);
            rows.setC(coluna2);


            consumo2.setRows(rows);

            /*######*/

            C coluna3 = new C();
            coluna3.setV("08-2015");

            C coluna4 = new C();
            coluna4.setV(7);

            Rows rows2 = new Rows();
            rows2.setC(coluna3);
            rows2.setC(coluna4);


            consumo2.setRows(rows2);

            /*######*/
            
            Gson gson = new Gson();
            jsonString = gson.toJson(consumo2);
            
            
        } catch(Exception e){
            logger.log(Level.SEVERE,"Error: {0} ", e );
        }
        
        return jsonString;
        
    } 
    
    
    @Path("/usuarios/auditoriaRecorrente")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuditoriaMaisRecorrente(){
        
        String jsonString=null;
        
        ConsumoVO consumo2 = new ConsumoVO();
        
        Cols cols1 = new Cols();
        cols1.setId("Auditoria");
        cols1.setLabel("Auditoria");
        cols1.setType("string");
        consumo2.setCols(cols1);
        
        Cols cols2 = new Cols();
        cols2.setId("Quantidade Carregada");
        cols2.setLabel("Quantidade Carregada");
        cols2.setType("number");
        consumo2.setCols(cols2);
        
        
        try{
            

            C coluna1 = new C();
            coluna1.setV("NCM ERRADA");

            C coluna2 = new C();
            coluna2.setV(5);

            Rows rows = new Rows();
            rows.setC(coluna1);
            rows.setC(coluna2);

            consumo2.setRows(rows);
                
            /*########*/
            
            C coluna3 = new C();
            coluna3.setV("CNPJ INVALIDO");

            C coluna4 = new C();
            coluna4.setV(38);

            Rows rows2 = new Rows();
            rows2.setC(coluna3);
            rows2.setC(coluna4);

            consumo2.setRows(rows2);
            
            
            /*########*/
            
            
            Gson gson = new Gson();
            jsonString = gson.toJson(consumo2);
            
            
        } catch(Exception e){
            logger.log(Level.SEVERE,"Error: {0} ", e );
        }
        
        
        //return "{\"cols\":[{\"id\":\"Auditoria\",\"label\":\"Auditoria\",\"type\":\"string\"},{\"id\":\"Quantidade Carregada\",\"label\":\"Quantidade Carregada\",\"type\":\"number\"}],\"rows\":[{\"c\":[{\"v\":\"teste\"},{\"v\":1}]},{\"c\":[{\"v\":\"teste3\"},{\"v\":2}]},{\"c\":[{\"v\":\"teste4\"},{\"v\":3}]}]}" ;
        
        return jsonString;
        
    }
    
    
}
