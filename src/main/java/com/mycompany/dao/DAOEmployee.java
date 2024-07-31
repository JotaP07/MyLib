/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.EmployeeM;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class DAOEmployee implements DAOGenerica<EmployeeM> {

    private ConexaoBanco conexao;

    public DAOEmployee() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(EmployeeM employee) {
        String sql = "INSERT INTO funcionarios "
                + "(nome_usuario, senha, nome, email, sexo_id, papel) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);

                st.setString(1, employee.getNomeUsuario());
                st.setString(2, employee.getSenha());
                st.setString(3, employee.getNome());
                st.setString(4, employee.getEmail());
                st.setInt(5, employee.getSexoId());
                st.setString(6, employee.getPapel());

                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcionário" + erro);
        }
    }

    @Override
    public void alterar(EmployeeM employee) {
        String sql = "UPDATE funcionarios SET nome_usuario = ?, senha = ?, nome = ?, email = ?, sexo_id = ?, papel = ? WHERE idfuncionario = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setString(1, employee.getNomeUsuario());
                st.setString(2, employee.getSenha());
                st.setString(3, employee.getNome());
                st.setString(4, employee.getEmail());
                st.setInt(5, employee.getSexoId());
                st.setString(6, employee.getPapel());
                st.setInt(7, employee.getId());

                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o funcionário: " + erro);
        }
    }

    @Override
    public void excluir(EmployeeM employee) {
        String sql = "DELETE FROM funcionarios WHERE idfuncionario = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, employee.getId());
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o funcionário: " + erro);
        }
    }

    @Override
    public ArrayList<EmployeeM> dashboard() {
        return null;
    }

    @Override
    public ArrayList<EmployeeM> listar(String filtro) throws Exception {
        List<EmployeeM> lista = new ArrayList<>();
        String sql = "SELECT f.idfuncionario, f.nome_usuario, f.senha, f.nome, f.email, s.descricao AS sexo_nome, f.papel "
                + "FROM funcionarios f "
                + "JOIN sexo s ON f.sexo_id = s.idsexo "
                + "WHERE f.idfuncionario  LIKE ? OR f.nome_usuario LIKE ? OR f.senha LIKE ? OR f.nome LIKE ? OR f.email LIKE ? OR s.descricao LIKE ? OR f.papel LIKE ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                String filtroLike = "%" + filtro + "%";
                st.setString(1, filtroLike);
                st.setString(2, filtroLike);
                st.setString(3, filtroLike);
                st.setString(4, filtroLike);
                st.setString(5, filtroLike);
                st.setString(6, filtroLike);
                st.setString(7, filtroLike);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    EmployeeM employee = new EmployeeM();
                    employee.setId(rs.getInt("idfuncionario"));
                    employee.setNomeUsuario(rs.getString("nome_usuario"));
                    employee.setSenha(rs.getString("senha"));
                    employee.setNome(rs.getString("nome"));
                    employee.setEmail(rs.getString("email"));
                    employee.setSexoNome(rs.getString("sexo_nome"));
                    employee.setPapel(rs.getString("papel"));
                    lista.add(employee);
                }

                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage());
        }

        return (ArrayList<EmployeeM>) lista;
    }

    public EmployeeM getEmployeeById(int id) throws SQLException {
        EmployeeM employee = null;
        String sql = "SELECT * FROM funcionarios WHERE idfuncionario = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    employee = new EmployeeM();
                    employee.setId(rs.getInt("idfuncionario"));
                    employee.setNomeUsuario(rs.getString("nome_usuario"));
                    employee.setSenha(rs.getString("senha"));
                    employee.setNome(rs.getString("nome"));
                    employee.setEmail(rs.getString("email"));
                    employee.setSexoId(rs.getInt("sexo_id"));
                    employee.setPapel(rs.getString("papel"));
                }
                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter detalhes do funcionário: " + e.getMessage());
        }
        return employee;
    }
    
}
