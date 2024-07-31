/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.dao.DAOEmployee;
import com.mycompany.models.EmployeeM;

import static com.mycompany.mylib.Dashboard.ShowJPanel;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class UpEmployee extends javax.swing.JPanel {

    boolean isEdition = false;// metodo para alternar para edição

    com.mycompany.models.EmployeeM employeeEdition;
    Map<String, Integer> sexoMap = new HashMap<>();

    public UpEmployee() {
        initComponents();
        InitStyles();
        populateSexoMap();
    }

    public UpEmployee(com.mycompany.models.EmployeeM employee) { // pagina de ediçao
        initComponents();
        isEdition = true;//pagina de alterar ativada
        employeeEdition = employee;
        InitStyles();
        populateSexoMap();// populando o comboBox
    }

    private void populateSexoMap() {
        sexoMap.put("Masculino", 1);
        sexoMap.put("Feminino", 2);
        sexoMap.put("Outros", 3);
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font; font-size: 20px;");
        title.setForeground(new Color(40, 42, 54));

        label.setForeground(new Color(40, 42, 54));
        label.putClientProperty("FlatLaf.styleClass", "large");
        txtNomeUsuario.putClientProperty("JTextField.placeholderText", "Insira o Login do Funcionário.");

        label2.setForeground(new Color(40, 42, 54));
        label2.putClientProperty("FlatLaf.styleClass", "large");
        txtSenha.putClientProperty("JTextField.placeholderText", "Insira a Senha do Funcionário.");

        label3.setForeground(new Color(40, 42, 54));
        label3.putClientProperty("FlatLaf.styleClass", "large");
        cbSexo.putClientProperty("JTextField.placeholderText", "Insira o Gênero do Usuário.");

        label4.setForeground(new Color(40, 42, 54));
        label4.putClientProperty("FlatLaf.styleClass", "large");
        txtNome.putClientProperty("JTextField.placeholderText", "Insira o Nome do Funcionário.");

        label7.setForeground(new Color(40, 42, 54));
        label7.putClientProperty("FlatLaf.styleClass", "large");
        txtEmail.putClientProperty("JTextField.placeholderText", "Insira o Email do Usuário.");

        label9.setForeground(new Color(40, 42, 54));
        label9.putClientProperty("FlatLaf.styleClass", "large");
        txtPapel.putClientProperty("JTextField.placeholderText", "Insira o Papel do Funcionário 'admin/funcionario'.");

        if (isEdition) {
            title.setText("EDITAR FUNCIONÁRIO");
            title.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font; font-size: 20px;");
            button.setText("ALTERAR");

            if (employeeEdition != null) {
                txtNomeUsuario.setText(employeeEdition.getNomeUsuario());
                txtSenha.setText(employeeEdition.getSenha());
                txtNome.setText(employeeEdition.getNome());
                txtEmail.setText(employeeEdition.getEmail());
                cbSexo.setSelectedIndex(employeeEdition.getSexoId() - 1);
                txtPapel.setText(employeeEdition.getPapel());
            }
        }
    }

    private boolean validateFields() {
        // Verifica se os campos de texto estão vazios
        if (txtNomeUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Nome/Login' é obrigatório.");
            return false;
        }
        if (txtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Senha' é obrigatório.");
            return false;
        }
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Nome' é obrigatório.");
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'E-mail' é obrigatório.");
            return false;
        }
        if (cbSexo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o 'Sexo' do funcionário.");
            return false;
        }
        if (txtPapel.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo 'Papel' é obrigatório.");
            return false;
        }

        // Verifica se o papel selecionado é válido
        String papel = txtPapel.getText().trim().toLowerCase();
        if (!papel.equals("funcionario") && !papel.equals("admin")) {
            JOptionPane.showMessageDialog(this, "O 'Papel' selecionado não é válido.");
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
        txtNome = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        txtPapel = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        cbSexo = new javax.swing.JComboBox<>();
        label3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

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

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        label4.setText("Nome");

        label2.setText("Senha");

        txtNomeUsuario.setDragEnabled(true);
        txtNomeUsuario.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeUsuarioActionPerformed(evt);
            }
        });

        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setText("Nome/Login");
        label.setOpaque(true);

        title.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        title.setText("CADASTRAR FUNCIONÁRIO");

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setText("E-mail");
        label7.setOpaque(true);

        label9.setText("Papel");

        txtPapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPapelActionPerformed(evt);
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

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        cbSexo.setSelectedIndex(-1);

        label3.setText("Sexo");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(txtSenha))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPapel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(label3)
                    .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 735, Short.MAX_VALUE)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPapel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addContainerGap(162, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeUsuarioActionPerformed
        // TODO add your handling code here:       

    }//GEN-LAST:event_txtNomeUsuarioActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtPapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPapelActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:

        if (!validateFields()) {
            return; // Se a validação falhar, retorna sem fazer nada
        }

        EmployeeM employee = new EmployeeM();

        employee.setNomeUsuario(txtNomeUsuario.getText());
        employee.setSenha(txtSenha.getText());
        employee.setNome(txtNome.getText());
        employee.setEmail(txtEmail.getText());
        String sexoSelecionado = cbSexo.getSelectedItem().toString();
        Integer sexoId = sexoMap.get(sexoSelecionado);
        employee.setSexoId(sexoId);
        employee.setPapel(txtPapel.getText());

        DAOEmployee daoEmployee = new DAOEmployee();

        if (isEdition) {
            // Att do cliente
            employee.setId(employeeEdition.getId()); // Necessario pra pegar o Id selecioado e editar
            if (!validateFields()) {
                return; // Se a validação falhar, retorna sem fazer nada
            }
            daoEmployee.alterar(employee);
        } else {
            // Cadastrando um novo cliente
            daoEmployee.inserir(employee);
        }
        ShowJPanel(new Employee());//volta a tela de usuarios
    }//GEN-LAST:event_buttonActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtPapel;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
