/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Monomio {
    private Integer coeficiente;
    private Integer exponente;
    public static final char VARIABLE='x';
    
    public Monomio () {
        
    }
    public Monomio(Integer coeficiente, Integer exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    
    public Integer compareTo(Monomio m) {
        return this.exponente-m.exponente;
    }

    public Integer getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Integer coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Integer getExponente() {
        return exponente;
    }

    public void setExponente(Integer exponente) {
        this.exponente = exponente;
    }
    
    public String toString() {
        return String.format("%d%c^%d ",this.coeficiente,Monomio.VARIABLE,this.exponente);
    }
}
