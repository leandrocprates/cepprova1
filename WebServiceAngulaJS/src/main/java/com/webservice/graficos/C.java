/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.graficos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer k
 */
@XmlRootElement
public class C implements Serializable{
    
    private Object v;
    private String f;

    public Object getV() {
        return v;
    }

    public void setV(Object v) {
        this.v = v;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
    

    
}
