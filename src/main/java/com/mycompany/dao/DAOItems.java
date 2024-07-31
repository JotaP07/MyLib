/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.ItemsM;
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
public class DAOItems implements DAOGenerica<ItemsM> {
    
    private ConexaoBanco conexao;
    
    public DAOItems(){
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(ItemsM items) {
    String sql = "INSERT INTO itens (tipo,"
            + " titulo,"
            + " autor,"
            + "editora,"
            + " genero,"
            + " ano_publicacao,"
            + " quantidade)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            if(this.conexao.conectar()){
            PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                
            st.setString(1, items.getTipo());
            st.setString(2, items.getTitulo());
            st.setString(3, items.getAutor());
            st.setString(4, items.getEditora());
            st.setString(5, items.getGenero());
            st.setInt(6, items.getAnoPublicacao());
            st.setInt(7, items.getQuantidade());
            st.execute(); //executa o comando no banco
            st.close(); //fecha a sentença
            JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
            this.conexao.getConnection().close();
            }
        }catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o item" + erro);
        }
    }

    @Override
    public void alterar(ItemsM items) {
                String sql = "UPDATE itens SET tipo = ?, titulo = ?, autor = ?, editora = ?, genero = ?, ano_publicacao = ?, quantidade = ? WHERE iditem = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setString(1, items.getTipo());
                st.setString(2, items.getTitulo());
                st.setString(3, items.getAutor());
                st.setString(4, items.getEditora());
                st.setString(5, items.getGenero());
                st.setInt(6, items.getAnoPublicacao());
                st.setInt(7, items.getQuantidade());
                st.setInt(8, items.getId());

                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o item: " + erro);
        }
    }

    @Override
    public void excluir(ItemsM items) {
        String sql = "DELETE FROM itens WHERE iditem = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, items.getId());
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Item excluído com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o item: " + erro);
        }
    }


    @Override
    public ArrayList<ItemsM> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
        public ArrayList<ItemsM> listar(String filtro) throws Exception{
    List<ItemsM> lista = new ArrayList<>();
        String sql = "SELECT i.iditem, i.tipo, i.titulo, i.autor, i.editora, i.genero, i.ano_publicacao, i.quantidade "
                   + "FROM itens i "
                   + "WHERE i.iditem LIKE ?"
                   + " OR i.tipo LIKE ?"
                   + " OR i.titulo LIKE ?"
                   + " OR i.autor LIKE ?"
                   + " OR i.editora LIKE ?"
                   + " OR i.genero LIKE ?"
                   + " OR i.ano_publicacao LIKE ?"
                   + " OR i.quantidade LIKE ?"; 
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                String filtroLike = "%" + filtro +"%";
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
                    ItemsM items = new ItemsM();
                    items.setId(rs.getInt("iditem"));
                    items.setTipo(rs.getString("tipo"));
                    items.setTitulo(rs.getString("titulo"));
                    items.setAutor(rs.getString("autor"));
                    items.setEditora(rs.getString("editora"));
                    items.setGenero(rs.getString("genero"));
                    items.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    items.setQuantidade(rs.getInt("quantidade"));
                    lista.add(items);
                }

                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o acervo: " + e.getMessage());
        }

        return (ArrayList<ItemsM>) lista;
            
        }
        
        
        public ItemsM getItemById(int id) throws SQLException {
        ItemsM item = null;
        String sql = "SELECT * FROM itens WHERE iditem = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    item = new ItemsM();
                    item.setId(rs.getInt("iditem"));
                    item.setTipo(rs.getString("tipo"));
                    item.setTitulo(rs.getString("titulo"));
                    item.setAutor(rs.getString("autor"));
                    item.setEditora(rs.getString("editora"));
                    item.setGenero(rs.getString("genero"));
                    item.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    item.setQuantidade(rs.getInt("quantidade"));
                }
                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter detalhes do cliente: " + e.getMessage());
        }
        return item;
    }
}
    