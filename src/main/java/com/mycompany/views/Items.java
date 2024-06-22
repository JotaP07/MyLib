/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.dao.DAOItems;
import com.mycompany.models.ItemsM;
import com.mycompany.mylib.Dashboard;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaop
 */
public class Items extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    public Items() {
        initComponents();
        InitStyles();
        LoadItems();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font; font-size: 20px;");
        title.setForeground(new Color(40, 42, 54));
        txtFitems.putClientProperty("JTextField.placeholderText", "🔎 Pesquisar");
    }
    
    private void ConultarTempoReal(){
                try {
            DAOItems dao = new DAOItems();
            DefaultTableModel model = (DefaultTableModel) tbItems.getModel();
            model.setRowCount(0);
            List<ItemsM> itemList = dao.listar(txtFitems.getText().trim());
            for (ItemsM item : itemList) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getTipo(),
                    item.getTitulo(),
                    item.getAutor(),
                    item.getEditora(),
                    item.getGenero(),
                    item.getAnoPublicacao(),
                    item.getQuantidade()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadItems() {
        try {
            DAOItems dao = new DAOItems();
            DefaultTableModel model = (DefaultTableModel) tbItems.getModel();
            model.setRowCount(0);
            List<ItemsM> itemList = dao.listar("");
            for (ItemsM item : itemList) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getTipo(),
                    item.getTitulo(),
                    item.getAutor(),
                    item.getEditora(),
                    item.getGenero(),
                    item.getAnoPublicacao(),
                    item.getQuantidade()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItems = new javax.swing.JTable();
        txtFitems = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 480));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(40, 42, 54));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setMinimumSize(new java.awt.Dimension(500, 100));
        jSeparator1.setName(""); // NOI18N
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(500, 100));

        jSeparator2.setBackground(new java.awt.Color(40, 42, 54));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        tbItems.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Título", "Autor", "Editora", "Gênero", "Ano P.", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItems.getTableHeader().setReorderingAllowed(false);
        tbItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbItemsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbItems);
        if (tbItems.getColumnModel().getColumnCount() > 0) {
            tbItems.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbItems.getColumnModel().getColumn(1).setPreferredWidth(30);
            tbItems.getColumnModel().getColumn(5).setPreferredWidth(40);
            tbItems.getColumnModel().getColumn(6).setPreferredWidth(30);
            tbItems.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        txtFitems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFitemsKeyReleased(evt);
            }
        });

        title.setText("ACERVO");

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setText("NOVO");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusable(false);
        addButton.setHideActionText(true);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setText("EDITAR");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editButton.setFocusable(false);
        editButton.setHideActionText(true);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setText("DELETAR");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deleteButton.setFocusable(false);
        deleteButton.setHideActionText(true);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                            .addComponent(txtFitems))))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(txtFitems, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItemsMousePressed

    }//GEN-LAST:event_tbItemsMousePressed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Dashboard.ShowJPanel(new UpItems());
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (tbItems.getSelectedRow() > -1) {
            try {
                int itemId = (int) tbItems.getValueAt(tbItems.getSelectedRow(), 0);
                DAOItems dao = new DAOItems();
                ItemsM item = dao.getItemById(itemId);
                Dashboard.ShowJPanel(new UpItems(item));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um item para editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbItems.getModel();
        if (tbItems.getSelectedRows().length < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Você deve selecionar um ou mais itens para excluir.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            DAOItems dao = new DAOItems();
            for (int i : tbItems.getSelectedRows()) {
                try {
                    int userId = (int) tbItems.getValueAt(i, 0); // obtem o ID do item pela linha selecionada
                    ItemsM user = new ItemsM();
                    user.setId(userId);
                    dao.excluir(user); // chama o método excluir passando o objeto UsersM com o ID
                    model.removeRow(i); // remove a linha da tabela
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void txtFitemsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFitemsKeyReleased
        // TODO add your handling code here:
        ConultarTempoReal();
    }//GEN-LAST:event_txtFitemsKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bg;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbItems;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtFitems;
    // End of variables declaration//GEN-END:variables
}
