/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.dao.DAOItems;
import com.mycompany.models.ItemsM;
import static com.mycompany.mylib.Dashboard.ShowJPanel;
import java.awt.Color;
import javax.swing.JOptionPane;

public class UpItems extends javax.swing.JPanel {

    boolean isEdition = false; // metodo para alternar para edição
    com.mycompany.models.ItemsM itemEdition;

    public UpItems() {
        initComponents();
        InitStyles();
    }

    public UpItems(com.mycompany.models.ItemsM item) {
        initComponents();
        isEdition = true;// ativando a pg alterar
        itemEdition = item;
        InitStyles();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font; font-size: 20px;");
        title.setForeground(new Color(40, 42, 54));

        label2.setForeground(new Color(40, 42, 54));
        label2.putClientProperty("FlatLaf.styleClass", "large");
        txtTipo.putClientProperty("JTextField.placeholderText", "Insira o Tipo do Item.");

        label3.setForeground(new Color(40, 42, 54));
        label3.putClientProperty("FlatLaf.styleClass", "large");
        txtTitulo.putClientProperty("JTextField.placeholderText", "Insira o Título de Publicação.");

        label4.setForeground(new Color(40, 42, 54));
        label4.putClientProperty("FlatLaf.styleClass", "large");
        txtAutor.putClientProperty("JTextField.placeholderText", "Insira o Autor do Item.");

        label5.setForeground(new Color(40, 42, 54));
        label5.putClientProperty("FlatLaf.styleClass", "large");
        txtEditora.putClientProperty("JTextField.placeholderText", "Insira a Categoria do Item.");

        label6.setForeground(new Color(40, 42, 54));
        label6.putClientProperty("FlatLaf.styleClass", "large");
        txtGenero.putClientProperty("JTextField.placeholderText", "Insira a Edição do Item.");

        label7.setForeground(new Color(40, 42, 54));
        label7.putClientProperty("FlatLaf.styleClass", "large");
        txtAnoPublicacao.putClientProperty("JTextField.placeholderText", "Insira o Ano de Publicação do Item.");

        label8.setForeground(new Color(40, 42, 54));
        label8.putClientProperty("FlatLaf.styleClass", "large");
        txtQuantidade.putClientProperty("JTextField.placeholderText", "Insira a Quantidade do Item.");

        if (isEdition) {
            title.setText("EDITAR ITEM");
            title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font; font-size: 20px;");
            button.setText("ALTERAR");

            if (itemEdition != null) {
                txtTipo.setText(itemEdition.getTipo());
                txtTitulo.setText(itemEdition.getTitulo());
                txtAutor.setText(itemEdition.getAutor());
                txtEditora.setText(itemEdition.getEditora());
                txtGenero.setText(itemEdition.getGenero());
                txtAnoPublicacao.setText(String.valueOf(itemEdition.getAnoPublicacao()));
                txtQuantidade.setText(String.valueOf(itemEdition.getQuantidade()));

            }
        }
    }

    private boolean validateFields() { //validação
        
        if (txtTipo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Tipo' é obrigatório.");
            return false;
        }
        if (!txtTipo.getText().trim().equalsIgnoreCase("Livro") && !txtTipo.getText().trim().equalsIgnoreCase("Revista")) {
            JOptionPane.showMessageDialog(this, "O campo 'Tipo' deve ser 'Livro' ou 'Revista'.");
            return false;
        }
        if (txtTitulo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Título' é obrigatório.");
            return false;
        }
        if (txtAutor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Autor' é obrigatório.");
            return false;
        }
        if (txtEditora.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Editora' é obrigatório.");
            return false;
        }
        if (txtGenero.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Gênero' é obrigatório.");
            return false;
        }
        if (txtAnoPublicacao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Ano de Publicação' é obrigatório.");
            return false;
        }
        if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Quantidade' é obrigatório.");
            return false;
        }

        // Verifica se os campos numéricos são válidos
        try {
            int anoPublicacao = Integer.parseInt(txtAnoPublicacao.getText().trim());
            if (anoPublicacao < 0) {
                JOptionPane.showMessageDialog(this, "O 'Ano de Publicação' deve ser um número positivo.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O 'Ano de Publicação' deve ser um número válido.");
            return false;
        }

        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            if (quantidade < 0) {
                JOptionPane.showMessageDialog(this, "A 'Quantidade' deve ser um número positivo.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A 'Quantidade' deve ser um número válido.");
            return false;
        }

        // Se todos os campos estiverem válidos, retorna true
        return true;
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
        jSeparator3 = new javax.swing.JSeparator();
        txtGenero = new javax.swing.JTextField();
        label6 = new javax.swing.JLabel();
        txtEditora = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        label3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        txtAnoPublicacao = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(738, 480));
        setMinimumSize(new java.awt.Dimension(738, 480));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(788, 480));

        jSeparator1.setBackground(new java.awt.Color(40, 42, 54));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 3));

        jSeparator2.setBackground(new java.awt.Color(40, 42, 54));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        jSeparator3.setBackground(new java.awt.Color(40, 42, 54));
        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator3.setMinimumSize(new java.awt.Dimension(500, 100));
        jSeparator3.setName(""); // NOI18N
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(500, 100));

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });

        label6.setText("Gênero");

        txtEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditoraActionPerformed(evt);
            }
        });

        label5.setText("Editora");

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        label4.setText("Autor");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        label3.setText("Titulo");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        label2.setText("Tipo");

        title.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        title.setText("CADASTRAR ITEM");

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setText("Ano de Publicação");
        label7.setOpaque(true);

        txtAnoPublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoPublicacaoActionPerformed(evt);
            }
        });

        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setText("CADASTRAR");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        label8.setBackground(new java.awt.Color(255, 255, 255));
        label8.setText("Quantidade");
        label8.setOpaque(true);

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEditora, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGenero)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 735, Short.MAX_VALUE)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addContainerGap(217, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditoraActionPerformed

    private void txtAnoPublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoPublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoPublicacaoActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:

        if (!validateFields()) {
            return; // Se a validação falhar, retorna sem fazer nada
        }

        ItemsM items = new ItemsM();
        items.setTipo(txtTipo.getText());
        items.setTitulo(txtTitulo.getText());
        items.setAutor(txtAutor.getText());
        items.setEditora(txtEditora.getText());
        items.setGenero(txtGenero.getText());
        items.setAnoPublicacao(Integer.parseInt(txtAnoPublicacao.getText())); // Converte o texto para um valor inteiro
        items.setQuantidade(Integer.parseInt(txtQuantidade.getText())); // Converte o texto para um valor inteiro

        DAOItems daoItems = new DAOItems();

        if (isEdition) {
            items.setId(itemEdition.getId()); // Necessario pra pegar o Id selecioado e editar
            daoItems.alterar(items);
        } else {
            //caso nao seja alteração ele realiza o cadastro novo normalmente
            daoItems.inserir(items);
        }
        ShowJPanel(new Items()); //volta a tela do acervo
    }//GEN-LAST:event_buttonActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAnoPublicacao;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
