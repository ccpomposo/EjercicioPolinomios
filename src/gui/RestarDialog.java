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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Monomio;

/**
 *
 * @author Usuario
 */
class RestarDialog extends JDialog{
    private JTextField txtCoef1;
    private JTextField txtCoef2;
    private JLabel lblVar1;
    private JLabel lblVar2;
    private JTextField txtExp1;
    private JTextField txtExp2;
    private JButton btnAgregar1;
    private JButton btnAgregar2;
    private JLabel lblPoli1;
    private JLabel lblPoli2;
    private JButton btnRestar;
    private JLabel lblResultado;
    private Controller controlador;

    public RestarDialog(JFrame owner, String titulo) {
        super(owner, titulo, true);
        super.setSize(700, 150);
        super.setLayout(new BorderLayout());
        this.controlador = new Controller();
        super.add(this.crearPnlPoli1(),BorderLayout.NORTH);
        JPanel pnlAux1 = new JPanel();
        pnlAux1.setLayout(new BorderLayout());
        pnlAux1.add(this.crearPnlPoli2(), BorderLayout.NORTH);
        JPanel pnlAux2 = new JPanel();
        pnlAux2.setLayout(new BorderLayout());
        pnlAux2.add(this.crearPnlSumar(), BorderLayout.NORTH);
        pnlAux1.add(pnlAux2);
        super.add(pnlAux1);
        super.setVisible(true);
    }
    
    private JPanel crearPnlPoli1() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.txtCoef1 = new JTextField(5);
        this.lblVar1 = new JLabel("x^");
        this.txtExp1 = new JTextField(5);
        this.btnAgregar1 = new JButton("Agregar");
        this.lblPoli1 = new JLabel("");
        
        this.btnAgregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Monomio m = new Monomio(Integer.valueOf(RestarDialog.this.txtCoef1.getText()),Integer.valueOf(RestarDialog.this.txtExp1.getText()));
                RestarDialog.this.controlador.agregarPoli1(m);
                RestarDialog.this.lblPoli1.setText(RestarDialog.this.controlador.getPoli1().imprimirPolinomio());
            }
        });
        
        panel.add(this.txtCoef1);
        panel.add(this.lblVar1);
        panel.add(this.txtExp1);
        panel.add(this.btnAgregar1);
        panel.add(this.lblPoli1);
        
        return panel;
    }
    
    private JPanel crearPnlPoli2() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.txtCoef2 = new JTextField(5);
        this.lblVar2 = new JLabel("x^");
        this.txtExp2 = new JTextField(5);
        this.btnAgregar2 = new JButton("Agregar");
        this.lblPoli2 = new JLabel("");
        
        this.btnAgregar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Monomio m = new Monomio(Integer.valueOf(RestarDialog.this.txtCoef2.getText()),Integer.valueOf(RestarDialog.this.txtExp2.getText()));
                RestarDialog.this.controlador.agregarPoli2(m);
                RestarDialog.this.lblPoli2.setText(RestarDialog.this.controlador.getPoli2().imprimirPolinomio());
            }
        });
        
        panel.add(this.txtCoef2);
        panel.add(this.lblVar2);
        panel.add(this.txtExp2);
        panel.add(this.btnAgregar2);
        panel.add(this.lblPoli2);
        
        return panel;
    }
    
    private JPanel crearPnlSumar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnRestar = new JButton("Restar");
        this.lblResultado = new JLabel("");
        
        this.btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    RestarDialog.this.lblResultado.setText(RestarDialog.this.controlador.restar().imprimirPolinomio());
                } catch (PolinomioFaltanteException ex) {
                    JOptionPane.showMessageDialog(RestarDialog.this,"Polinomio faltante");
                }
            }
        });
        
        panel.add(btnRestar);
        panel.add(lblResultado);
        
        return panel;
    }
}
