/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.chart.PieChart.Data;


/**
 *
 * @author leonardo
 */
public class Responsavel extends Pessoa{
    
    private String cargo;
    private Data dataNascimento;     
    private Radio radio;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
 
      
    
    
            
}
