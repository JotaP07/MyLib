package com.mycompany.dao;

import com.mycompany.db.ConexaoBanco;
import com.mycompany.models.LogM;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOReports {

    private final ConexaoBanco conexao;

    public DAOReports() {
        this.conexao = new ConexaoBanco();
    }

    public ArrayList<LogM> listar(String filtro) throws Exception {
        List<LogM> lista = new ArrayList<>();
        String sql = "SELECT i.acao, i.timestamp "
                + "FROM logs i "
                + "WHERE i.acao LIKE ?"
                + " OR i.timestamp LIKE ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
                String filtroLike = "%" + filtro + "%";
                st.setString(1, filtroLike);
                st.setString(2, filtroLike);

                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    LogM items = new LogM();
                    items.setAcao(rs.getString("acao"));
                    items.setTimestamp(rs.getTimestamp("timestamp"));
                    lista.add(items);
                }

                rs.close();
                st.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o relatório: " + e.getMessage());
        }

        return (ArrayList<LogM>) lista;

    }

}
