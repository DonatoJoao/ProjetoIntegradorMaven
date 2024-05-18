/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

/**
 *
 * @author JOÃO
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textUsuarioInput = new javax.swing.JTextArea();
        textSenha = new javax.swing.JPasswordField();
        jLabel4_usuario = new javax.swing.JLabel();
        jLabel5_senha = new javax.swing.JLabel();
        jLabel2_login = new javax.swing.JLabel();
        jLabel3_painelLogin = new javax.swing.JLabel();
        jLabel1_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textUsuarioInput.setColumns(20);
        textUsuarioInput.setRows(5);
        getContentPane().add(textUsuarioInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 330, 40));

        textSenha.setText("jPasswordField1");
        textSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 330, 40));

        jLabel4_usuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4_usuario.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4_usuario.setText("Usuário");
        getContentPane().add(jLabel4_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 90, 40));

        jLabel5_senha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5_senha.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5_senha.setText("Senha");
        getContentPane().add(jLabel5_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 80, 40));

        jLabel2_login.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2_login.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2_login.setText("Login");
        getContentPane().add(jLabel2_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 80, 50));

        jLabel3_painelLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/icons/painel2.png"))); // NOI18N
        getContentPane().add(jLabel3_painelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel1_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/fundoDesenho.jpg"))); // NOI18N
        jLabel1_fundo.setText("Login");
        getContentPane().add(jLabel1_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 599, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1_fundo;
    private javax.swing.JLabel jLabel2_login;
    private javax.swing.JLabel jLabel3_painelLogin;
    private javax.swing.JLabel jLabel4_usuario;
    private javax.swing.JLabel jLabel5_senha;
    private javax.swing.JPasswordField textSenha;
    private javax.swing.JTextArea textUsuarioInput;
    // End of variables declaration//GEN-END:variables
}
