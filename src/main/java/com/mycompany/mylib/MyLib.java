/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mylib;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme;


/**
 *
 * @author joaop
 */
public class MyLib {

    public static void main(String[] args) {
        FlatDraculaIJTheme.setup();
        new Login().setVisible(true);
        
    }
}
