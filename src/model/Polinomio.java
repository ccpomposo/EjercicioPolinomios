/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.PolinomioFaltanteException;

/**
 *
 * @author Usuario
 */
public class Polinomio {
    private Nodo inicio;
    
    public void insertar(Monomio e) {
        Nodo nuevo = new Nodo(e);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            if (aux.getDato().compareTo(nuevo.getDato())<=0){
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else {
                Nodo anterior = null;
                while(aux != null && nuevo.getDato().compareTo(aux.getDato())<0) {
                    anterior = aux;
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux);
                anterior.setSiguiente(nuevo);
            }
        }
    }
    
    public void recorrer() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato());
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }
    
    public void eliminar(Nodo e) {
        Nodo buscado = e;
        Nodo aux = inicio;
        Nodo anterior = null;
        while(aux != null && buscado != aux) {
            anterior = aux;
            aux = aux.getSiguiente();
        }
        if (aux != null) {
            if (anterior == null) {
                inicio = aux.getSiguiente();
                buscado.setSiguiente(null);
            } else {
                anterior.setSiguiente(aux.getSiguiente());
                buscado.setSiguiente(null);
            }
        }
    }
    
    public void reducir() throws PolinomioFaltanteException {
        if(this.inicio == null){
            throw new PolinomioFaltanteException();
        }
        Nodo aux = inicio;
        while (aux != null) {
            while (aux.getSiguiente() != null && aux.getDato().compareTo(aux.getSiguiente().getDato())==0){
                aux.getDato().setCoeficiente(aux.getDato().getCoeficiente()+aux.getSiguiente().getDato().getCoeficiente());
                this.eliminar(aux.getSiguiente());
            }
            aux = aux.getSiguiente();
        }
    }
    
    private void insertar(Polinomio p) throws PolinomioFaltanteException{
        this.reducir();
        p.reducir();
        Nodo aux = p.inicio;
        while(aux != null) {
            this.insertar(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
    
    public Polinomio sumar(Polinomio p) throws PolinomioFaltanteException {
        Polinomio resultado;
        if(this.inicio == null || p.inicio == null){
            throw new PolinomioFaltanteException();
        }
        this.reducir();
        p.reducir();
        Nodo aux = p.inicio;
        while(aux != null) {
            this.insertar(aux.getDato());
            aux = aux.getSiguiente();
        }
        this.reducir();
        resultado = this;
        return resultado;
    }
    
    public Polinomio restar(Polinomio p) throws PolinomioFaltanteException {
        Polinomio resultado;
        if(this.inicio == null || p.inicio == null){
            throw new PolinomioFaltanteException();
        }
        Nodo aux = p.inicio;
        this.reducir();
        p.reducir();
        while(aux != null) {
            aux.getDato().setCoeficiente(aux.getDato().getCoeficiente()*-1);
            this.insertar(aux.getDato());
            aux = aux.getSiguiente();
        }
        this.reducir();
        resultado = this;
        return resultado;
    }
    
    public Polinomio multiplicar(Polinomio p) throws PolinomioFaltanteException{
        Polinomio resultado = new Polinomio();
        if(this.inicio == null || p.inicio == null){
            throw new PolinomioFaltanteException();
        }
        this.reducir();
        this.recorrer();
        p.reducir();
        p.recorrer();
        Nodo aux = p.inicio;
        while(aux != null) {
            resultado.insertar(this.multiplicar(aux.getDato()));
            aux = aux.getSiguiente();
        }
        resultado.reducir();
        return resultado;
    }
    
    private Polinomio multiplicar(Monomio m) {
        Polinomio resultado = new Polinomio();
        Nodo aux = this.inicio;
        Monomio mAux = new Monomio();
        while(aux != null) {
            mAux.setCoeficiente(aux.getDato().getCoeficiente()*m.getCoeficiente());
            mAux.setExponente(aux.getDato().getExponente()+m.getExponente());
            System.out.println(mAux);
            resultado.insertar(mAux);
            aux = aux.getSiguiente();
        }
        //resultado.reducir();
        System.out.print(" ****** ");
        resultado.recorrer();
        return resultado;
    }
    
    public String imprimirPolinomio(){
        Nodo aux = inicio;
        String resultado = "";
        while (aux != null) {
            resultado = resultado +aux.getDato().toString()+" ";
            aux = aux.getSiguiente();
        }
        return resultado;
    }
        
}

class Test {
    public static void main(String[] args) throws PolinomioFaltanteException {
   
        Polinomio p = new Polinomio();
        p.insertar(new Monomio(2,0));
        p.insertar(new Monomio(1,2));
        p.recorrer();
        
        Polinomio p2 = new Polinomio();
        p2.insertar(new Monomio(1,3));
        p2.insertar(new Monomio(1,2));
        p2.recorrer();
        
        Polinomio multi = p.multiplicar(p2);
        multi.recorrer();
    }
}