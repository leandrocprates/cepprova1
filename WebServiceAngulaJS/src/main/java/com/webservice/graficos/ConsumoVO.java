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
public class ConsumoVO implements Serializable{
    private List<Cols> cols; 
    private List<Rows> rows;

    public ConsumoVO() {
        this.cols = new ArrayList<Cols>();
        this.rows = new ArrayList<Rows>();
    }

    public List<Cols> getCols() {
        return cols;
    }

    public void setCols(Cols cols) {
        this.cols.add(cols) ;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(Rows rows) {
        this.rows.add(rows);
    }

    
}

