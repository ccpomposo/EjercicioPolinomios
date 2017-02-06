/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controller;
import exceptions.PolinomioFaltanteException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Monomio;

/**
 *
 * @author Usuario
 */
class ReducirDialog extends JDialog{
    private JTextField txtCoef;
    private JLabel lblVar;
    private JTextField txtExp;
    private JButton btnAgregar;
    private JLabel lblPoli;
    private JButton btnReducir;
    private JLabel lblResultado;
    private Controller controlador;

    public ReducirDialog(JFrame owner, String titulo) {
        super(owner, titulo, true);
        super.setSize(700, 150);
        super.setLayout(new BorderLayout());
        this.controlador = new Controller();
        super.add(this.crearPnlPoli1(),BorderLayout.NORTH);
        super.add(this.crearPnlReducir(), BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private JPanel crearPnlPoli1() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.txtCoef = new JTextField(5);
        this.lblVar = new JLabel("x^");
        this.txtExp = new JTextField(5);
        this.btnAgregar = new JButton("Agregar");
        this.lblPoli = new JLabel("");
        
        this.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Monomio m = new Monomio(Integer.valueOf(ReducirDialog.this.txtCoef.getText()),Integer.valueOf(ReducirDialog.this.txtExp.getText()));
                ReducirDialog.this.controlador.agregarPoli1(m);
                ReducirDialog.this.lblPoli.setText(ReducirDialog.this.controlador.getPoli1().imprimirPolinomio());
            }
        });
        
        panel.add(this.txtCoef);
        panel.add(this.lblVar);
        panel.add(this.txtExp);
        panel.add(this.btnAgregar);
        panel.add(this.lblPoli);
        
        return panel;
    }
    
    private JPanel crearPnlReducir() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnReducir = new JButton("Reducir");
        this.lblResultado = new JLabel("");
        
        this.btnReducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    ReducirDialog.this.lblResultado.setText(ReducirDialog.this.controlador.reducir().imprimirPolinomio());
                } catch (PolinomioFaltanteException ex) {
                    JOptionPane.showMessageDialog(ReducirDialog.this,"Polinomio faltante");
                }
            }
        });
        
        panel.add(btnReducir);
        panel.add(lblResultado);
        
        return panel;
    }
}
