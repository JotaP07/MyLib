package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.LendingsM;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DAOLendings implements DAOGenerica<LendingsM> {

    private ConexaoBanco conexao;

    public DAOLendings() {
        this.conexao = new ConexaoBanco();
    }

    public void emprestar(LendingsM lending) {
        String sql = "INSERT INTO emprestimos (funcionario_id, cliente_id, item_id, devolvido) VALUES (?, ?, ?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, lending.getFuncionarioId());
                st.setInt(2, lending.getClienteId());
                st.setInt(3, lending.getItemId());
                st.setInt(4, lending.getDevolvido());
                st.execute();
                st.close();
                JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar o empréstimo: " + e.getMessage());
        }
    }

    public void devolver(LendingsM lending) {
        //"INSERT INTO emprestimos (funcionario_id, cliente_id, item_id, , devolvido) VALUES (?, ?, ?, ?)";
        String sql = "UPDATE emprestimos SET funcionario_id = ?, cliente_id = ?, item_id = ?, devolvido = ? WHERE idemprestimo = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, lending.getFuncionarioId());
                st.setInt(2, lending.getClienteId());
                st.setInt(3, lending.getItemId());
                st.setInt(4, lending.getDevolvido());
                st.setInt(5, lending.getId());
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Item devolvido com sucesso!");
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao devolver o item: " + e.getMessage());
        }
    }

    @Override
    public void inserir(LendingsM lending) {
    }

    @Override
    public void alterar(LendingsM lending) {
    }

    public boolean clienteExiste(int clienteId) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE idcliente = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, clienteId);
                ResultSet rs = st.executeQuery();
                boolean existe = rs.next() && rs.getInt(1) > 0;
                rs.close();
                st.close();
                this.conexao.getConnection().close();
                return existe;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar o cliente: " + e.getMessage());
        }
        return false;
    }

 public enum ItemStatus {
        NOT_FOUND,
        UNAVAILABLE,
        AVAILABLE
    }

    // Método para verificar a disponibilidade do item
    public ItemStatus verificarItemDisponivel(int itemId) {
        String sql = "SELECT quantidade FROM itens WHERE iditem = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, itemId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    int quantidade = rs.getInt("quantidade");
                    rs.close();
                    st.close();
                    this.conexao.getConnection().close();
                    return quantidade > 0 ? ItemStatus.AVAILABLE : ItemStatus.UNAVAILABLE;
                } else {
                    rs.close();
                    st.close();
                    this.conexao.getConnection().close();
                    return ItemStatus.NOT_FOUND;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar disponibilidade do item: " + e.getMessage());
        }
        return ItemStatus.NOT_FOUND;
    }


    @Override
    public void excluir(LendingsM lending) { //caso eu adicione o metodo de excluir
//        String sql = "DELETE FROM emprestimos WHERE idemprestimo = ?";
//        try {
//            if (this.conexao.conectar()) {
//                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
//                st.setInt(1, lending.getId());
//                st.executeUpdate();
//                st.close();
//                JOptionPane.showMessageDialog(null, "Empréstimo excluído com sucesso!");
//                this.conexao.getConnection().close();
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir o empréstimo: " + e.getMessage());
//        }
    }

    @Override
    public ArrayList<LendingsM> listar(String filtro) throws Exception {
        ArrayList<LendingsM> lista = new ArrayList<>();
        String sql = "SELECT i.idemprestimo, f.nome_usuario AS nome_funcionario, c.nome AS cliente_nome, t.titulo AS titulo_item, i.devolvido "
                + "FROM emprestimos i "
                + "JOIN funcionarios f ON i.funcionario_id = f.idfuncionario "
                + "JOIN clientes c ON i.cliente_id = c.idcliente "
                + "JOIN itens t ON i.item_id = t.iditem "
                + "WHERE i.idemprestimo LIKE ?"
                + " OR f.nome_usuario LIKE ?"
                + " OR c.nome LIKE ?"
                + " OR t.titulo LIKE ?"
                + " OR i.devolvido LIKE ?";

        // String sql = "SELECT * FROM emprestimos WHERE idemprestimo LIKE ? OR funcionario_id LIKE ? OR cliente_id LIKE ? OR item_id LIKE ? OR devolvido ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                String filtroLike = "%" + filtro + "%";
                st.setString(1, filtroLike);
                st.setString(2, filtroLike);
                st.setString(3, filtroLike);
                st.setString(4, filtroLike);
                st.setString(5, filtroLike);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    LendingsM lending = new LendingsM();
                    lending.setId(rs.getInt("idemprestimo"));
                    lending.setNomeFuncionario(rs.getString("nome_funcionario"));
                    lending.setNomeCliente(rs.getString("cliente_nome"));
                    lending.setNomeItem(rs.getString("titulo_item"));
                    lending.setDevolvido(rs.getInt("devolvido"));
                    lista.add(lending);
                }
                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar empréstimos e devoluções: " + e.getMessage());
        }
        return (ArrayList<LendingsM>) lista;
    }

    @Override
    public ArrayList<LendingsM> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<LendingsM> listarDevolucao(String filtro) throws Exception {
        ArrayList<LendingsM> lista = new ArrayList<>();
        String sql = "SELECT i.idemprestimo, f.nome_usuario AS nome_funcionario, c.nome AS cliente_nome, t.titulo AS titulo_item, i.devolvido "
                + "FROM emprestimos i "
                + "JOIN funcionarios f ON i.funcionario_id = f.idfuncionario "
                + "JOIN clientes c ON i.cliente_id = c.idcliente "
                + "JOIN itens t ON i.item_id = t.iditem "
                + "WHERE (i.idemprestimo LIKE ?"
                + " OR f.nome_usuario LIKE ?"
                + " OR c.nome LIKE ?"
                + " OR t.titulo LIKE ?)"
                + " AND i.devolvido = 0";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                String filtroLike = "%" + filtro + "%";
                st.setString(1, filtroLike);
                st.setString(2, filtroLike);
                st.setString(3, filtroLike);
                st.setString(4, filtroLike);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    LendingsM lending = new LendingsM();
                    lending.setId(rs.getInt("idemprestimo"));
                    lending.setNomeFuncionario(rs.getString("nome_funcionario"));
                    lending.setNomeCliente(rs.getString("cliente_nome"));
                    lending.setNomeItem(rs.getString("titulo_item"));
                    lending.setDevolvido(rs.getInt("devolvido"));
                    lista.add(lending);
                }
                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar empréstimos e devoluções: " + e.getMessage());
        }
        return (ArrayList<LendingsM>) lista;
    }

    public LendingsM getItemById(int id) throws SQLException {
        LendingsM item = null;
        String sql = "SELECT * FROM emprestimos WHERE idemprestimo = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    item = new LendingsM();
                    item.setId(rs.getInt("idemprestimo"));
                    item.setFuncionarioId(rs.getInt("funcionario_id"));
                    item.setClienteId(rs.getInt("cliente_id"));
                    item.setItemId(rs.getInt("item_id"));
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
