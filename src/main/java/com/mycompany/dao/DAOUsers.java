/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.UsersM;
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
public class DAOUsers implements DAOGenerica<UsersM> {

    private ConexaoBanco conexao;

    public DAOUsers() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(UsersM users) {
        String sql = "INSERT INTO clientes "
                + "(nome, cpf, sexo_id, endereco, cep, telefone, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);

                st.setString(1, users.getNome());
                st.setString(2, users.getCpf());
                st.setInt(3, users.getSexoId());
                st.setString(4, users.getEndereco());
                st.setString(5, users.getCep());
                st.setString(6, users.getTelefone());
                st.setString(7, users.getEmail());

                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente" + erro);
        }
    }

    @Override
    public void alterar(UsersM users) {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, sexo_id = ?, endereco = ?, cep = ?, telefone = ?, email = ? WHERE idcliente = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setString(1, users.getNome());
                st.setString(2, users.getCpf());
                st.setInt(3, users.getSexoId());
                st.setString(4, users.getEndereco());
                st.setString(5, users.getCep());
                st.setString(6, users.getTelefone());
                st.setString(7, users.getEmail());
                st.setInt(8, users.getId());

                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente: " + erro);
        }
    }

    @Override
    public void excluir(UsersM users) {
        String sql = "DELETE FROM clientes WHERE idcliente = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, users.getId());
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente: " + erro);
        }
    }

    @Override
    public ArrayList<UsersM> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<UsersM> listar(String filtro) throws Exception {
        List<UsersM> lista = new ArrayList<>();
        String sql = "SELECT c.idcliente, c.nome, c.cpf, s.descricao AS sexo_nome, c.endereco, c.cep, c.telefone, c.email "
                + "FROM clientes c "
                + "JOIN sexo s ON c.sexo_id = s.idsexo "
                + "WHERE c.idcliente LIKE ?"
                + " OR c.nome LIKE ?"
                + " OR c.cpf LIKE ?"
                + " OR s.descricao LIKE ?"
                + " OR c.endereco LIKE ?"
                + " OR c.cep LIKE ?"
                + " OR c.telefone LIKE ?"
                + " OR c.email LIKE ?";
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
                st.setString(8, filtroLike);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    UsersM users = new UsersM();
                    users.setId(rs.getInt("idcliente"));
                    users.setNome(rs.getString("nome"));
                    users.setCpf(rs.getString("cpf"));
                    users.setSexoNome(rs.getString("sexo_nome"));
                    users.setEndereco(rs.getString("endereco"));
                    users.setCep(rs.getString("cep"));
                    users.setTelefone(rs.getString("telefone"));
                    users.setEmail(rs.getString("email"));
                    lista.add(users);
                }

                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }

        return (ArrayList<UsersM>) lista;
    }

    public UsersM getUserById(int id) throws SQLException {
        UsersM user = null;
        String sql = "SELECT * FROM clientes WHERE idcliente = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    user = new UsersM();
                    user.setId(rs.getInt("idcliente"));
                    user.setNome(rs.getString("nome"));
                    user.setCpf(rs.getString("cpf"));
                    user.setSexoId(rs.getInt("sexo_id"));
                    user.setEndereco(rs.getString("endereco"));
                    user.setCep(rs.getString("cep"));
                    user.setTelefone(rs.getString("telefone"));
                    user.setEmail(rs.getString("email"));
                }
                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter detalhes do cliente: " + e.getMessage());
        }
        return user;
    }
    
    /*
        public ArrayList<Cadastro> consultar(String str) {
        
        ArrayList<Cadastro> listaCadastrosStr = new ArrayList<Cadastro>();
        String sql = "SELECT c.idcad, c.nomecad, c.cpf, c.email, s.nomesexo "+
                     "FROM cadbasico as c "+
                     "LEFT JOIN cadsexo AS s ON (s.idsexo = c.idsexo) "+
                     "WHERE ( UPPER(c.nomecad like UPPER(?))) "+   
                     "ORDER BY s.nomesexo ";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                sentenca.setString(1, "%"+str+"%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCad(resultadoSentenca.getInt("idcad"));
                    cadastro.setNomeCad(resultadoSentenca.getString("nomecad"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.SetNomeSexo(resultadoSentenca.getString("nomesexo"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    
                    listaCadastrosStr.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastrosStr;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }*/
}
