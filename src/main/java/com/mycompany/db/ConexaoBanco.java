package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {   
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao; 
    
    public ConexaoBanco(){
        this.servidor = "200.195.171.122";
        this.banco = "grupo11_Jp";
        this.usuario = "grupo11";
        this.senha = "9agmsegriCatwXLH";
    }
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco+"?serverTimezone=UTC", this.usuario, this.senha);
            return true;
        }
        catch(ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Connection getConnection() {
        return conexao;
    }
}
