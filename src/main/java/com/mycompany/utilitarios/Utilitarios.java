/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utilitarios;

/**
 *
 * @author joaop
 */
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {

    public void Limpar(JPanel container) {
        Component conponents[] = container.getComponents();
        for (Component componet : conponents) {
            if (componet instanceof JTextField) {
                ((JTextField) componet).setText(null);
            }
        }
    }

    public void InserirIcone(JFrame frm) {
        try {
            String path = "/imagens/undefined.png";
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path));
            frm.setIconImage(icon);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
