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
public class Nodo {
    private Monomio dato;
    private Nodo siguiente;
    
    public Nodo (Monomio dato) {
        this.dato = dato;
    }

    public Monomio getDato() {
        return dato;
    }

    public void setDato(Monomio dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
