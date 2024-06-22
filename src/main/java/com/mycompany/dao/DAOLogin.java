package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.EmployeeM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAOLogin {
    
    private ConexaoBanco conexao;
    
    public DAOLogin() {
        this.conexao = new ConexaoBanco();
    }
    
    public EmployeeM autenticar(String username, String password) {
        String sql = "SELECT * FROM funcionarios WHERE nome_usuario = ? AND senha = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    EmployeeM funcionario = new EmployeeM();
                    funcionario.setId(rs.getInt("idfuncionario"));
                    funcionario.setNomeUsuario(rs.getString("nome_usuario"));
                    funcionario.setSenha(rs.getString("senha"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setSexoId(rs.getInt("sexo_id"));
                    funcionario.setPapel(rs.getString("papel"));
                    return funcionario;
                }
                rs.close();
                stmt.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar o usuário: " + ex.getMessage());
        }
        return null;
    }
}
