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
        this.servidor = "localhost";
        this.banco = "biblioteca";
        this.usuario = "root"; // coloque o usuário do seu banco
        this.senha = ""; // coloque a senha do seu banco
    }
    
    public boolean conectar(){
        try{
            // Carregamento do driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelecendo a conexão com o banco de dados
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
