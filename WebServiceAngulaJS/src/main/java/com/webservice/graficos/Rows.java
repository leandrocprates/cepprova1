/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.graficos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer k
 */
@XmlRootElement
public class Rows implements Serializable{
  
    private List<C> c; 

    public Rows() {
        this.c = new ArrayList<C>();
    }

    public List<C> getC() {
        return c;
    }

    public void setC(C c) {
        this.c.add(c);
    }
    
    
}
