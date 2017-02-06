/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.PolinomioFaltanteException;
import model.Monomio;
import model.Polinomio;

/**
 *
 * @author Usuario
 */
public class Controller {
    
    private Polinomio poli1;
    private Polinomio poli2;
    
    public Polinomio sumar() throws PolinomioFaltanteException {
        return poli1.sumar(poli2);
    }
    
    public Polinomio restar() throws PolinomioFaltanteException {
        return poli1.restar(poli2);
    }
    public void agregarPoli1(Monomio m){
        if(poli1  == null){
            poli1 = new Polinomio();
        }
        poli1.insertar(m);
    }
    
    public void agregarPoli2(Monomio m){
        if(poli2  == null){
            poli2 = new Polinomio();
        }
        poli2.insertar(m);
    }
    
    public Polinomio reducir() throws PolinomioFaltanteException {
        poli1.reducir();
        return poli1;
    }

    public Polinomio getPoli1() {
        return poli1;
    }

    public Polinomio getPoli2() {
        return poli2;
    }
}
