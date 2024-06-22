/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import java.util.ArrayList;

/**
 *
 * @author joaop
 */
public interface DAOGenerica <ObjetoGenerico>{
    
   public void inserir(ObjetoGenerico objt);
    
    public void alterar(ObjetoGenerico objt);
    
    public void excluir(ObjetoGenerico objt);
    
   // public ArrayList<ObjetoGenerico> consultar();

    public ArrayList<ObjetoGenerico> dashboard(); 
    
    public ArrayList<ObjetoGenerico> listar(String filtro) throws Exception;
    
}
