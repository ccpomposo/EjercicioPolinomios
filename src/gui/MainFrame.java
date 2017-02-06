/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{
    
    private JButton btnReducir;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JButton btnResolver;
    
    public MainFrame() {
        super("Polinomios v1.0");
        super.setSize(600, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
    }
    
    private JPanel crearReducir() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnReducir = new JButton("Reducir");
        this.btnReducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ReducirDialog();
            }
        });
        
        return panel;
    }
    
    private JPanel crearSumar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnSumar = new JButton("Sumar");
        this.btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new SumarDialog();
            }
        });
        return panel;
    }
    
    private JPanel crearRestar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnRestar = new JButton("Restar");
        this.btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new RestarDialog();
            }
        });
        
        return panel;
    }
    
    private JPanel crearMultiplicar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnMultiplicar = new JButton("Multiplicar");
        this.btnMultiplicar.setEnabled(false);
        
        return panel;
    }
    
    private JPanel crearDividir() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnDividir = new JButton("Dividir");
        this.btnMultiplicar.setEnabled(false);
        
        return panel;
    }
    
    private JPanel crearResolver() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.btnResolver = new JButton("Resolver");
        this.btnMultiplicar.setEnabled(false);
        
        return panel;
    }
}
