# Projeto Integrador I - Univesp

###  A Proposta desse projeto é desenvolver uma aplicação WEB para: cadastro de usuários (colaboradores e clientes), produtos, agendamentos, controle de horas dos colaboradores e planos de assinaturas dos clientes. 
***
<div align="center">
 <img src="https://github.com/DonatoJoao/ProjetoIntegradorMaven/blob/master/src/main/java/com/barbearia/View/imagens/barbearia%20(2).jpg" width="450"/>
</div>

***
 
## Introdução 

Para esta aplicação utilizaremos a arquitetura de software MVC - Model-View-Controller, o desenvolvimento será em JAVA e a IDE usada será IntelliJ IDEA. O Banco de dados eescolhido foi...
***

## Objetivo

Desenvolver um sistema para: gerar controle de colaboradores, cadastro de clientes, planos de assinaturas e agendamentos.
***

## Arquitetura

<div align="center">
 <img src="https://github.com/DonatoJoao/ProjetoIntegradorMaven/blob/master/src/main/resources/imagens/arquitetura.jpg" witdth="450"/>
</div>

***

## Funcionamento 

Deverá seguir esses passos: 

1. Criando as Controllers

<details>
<summary>Agenda</summary>
```ruby
package com.barbearia.Controller;

import com.barbearia.Controller.Helper.AgendaHelper;
import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.DAO.AgendamentoDAO;
import com.barbearia.Model.DAO.ClienteDAO;
import com.barbearia.Model.DAO.ServicoDAO;
import com.barbearia.Model.Servico;
import com.barbearia.View.Agenda;
import java.util.ArrayList;

public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    public void atualizaTabela(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        helper.preencherTabela(agendamentos);
    }
    public void atualizaCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        helper.preencherClientes(clientes);
    }
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        helper.preencherServicos(servicos);
    }
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    public void agendar(){
//        Agendamento agendamento = helper.obterModelo();
//        new AgendamentoDAO().insert(agendamento);
//        Correio correio = new Correio();
//        correio.NotificarPorEmail(agendamento);
//
//        atualizaTabela();
//        helper.limpaTela();
    }
    }
```
</details>

<details>
<summary>Login</summary>
```ruby

package com.barbearia.Controller;

import com.barbearia.Controller.Helper.LoginHelper;
import com.barbearia.Model.DAO.UsuarioDAO;
import com.barbearia.Model.Usuario;
import com.barbearia.View.Login;
import com.barbearia.View.MenuPrincipal;

public class LoginController {
    private final Login view;
    private final LoginHelper helper;
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    //Toda lógica/regras de negócio deverá estar aqui

    public void entrarNoSistema(){
        //Pegar usuario da View
        Usuario usuario = helper.obterModelo();    
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        if (usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else{
            view.exibeMensagem("Usuário ou senha inválidos");
        }
    }
   
    public void fizTarefa(){
        System.out.println("Busquei algo");
        this.view.exibeMensagem("Executei tarefa");
    }
}
``` 
</details>

<details>
<summary>Menu Principal</summary>
```ruby

package com.barbearia.Controller;

import com.barbearia.View.Agenda;
import com.barbearia.View.MenuPrincipal;

public class MenuPrincipalController {
    private final MenuPrincipal view;
    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    public void navegarParaAgenda(){
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
}
``` 
</details>

2. Criando os Controllers Helper

<details>
<summary>Agenda</summary>
```ruby

package com.barbearia.Controller.Helper;

import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.Servico;
import com.barbearia.View.Agenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AgendaHelper implements IHelper {
    private final Agenda view;
    public AgendaHelper(Agenda view) {
        this.view = view;
    }
    public void preencherTabela(ArrayList<Agendamento> agendamentos){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        for (Agendamento agendamento : agendamentos){
            tableModel.addRow(new Object[]{
                    agendamento.getIdAgendamento(),
                    agendamento.getCliente().getNome(),
                    agendamento.getServico().getDescricao(),
                    agendamento.getDataAgendamento(),
                    agendamento.getObservacao()
            });
        }
    }
    public void preencherClientes(ArrayList<Cliente> clientes){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
    }
    public void preencherServicos(ArrayList<Servico> servicos){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }
    public void setarValor(float valor) {
       view.getTextValor().setText(valor+"");
    }
    public Servico obterServico() {
        return (Servico) view.getjComboBoxServico().getSelectedItem();
    }
    @Override
    public Agendamento obterModelo() {
        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getTextObservacao().getText();

        Agendamento agendamento = new Agendamento(id,cliente,servico,valor,dataHora, observacao);
        return agendamento;
    }
    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }
    private Cliente obterCliente() {
        return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }
}
```
 
</details>

<details>
<summary>IHelper</summary>
```ruby

package com.barbearia.Controller.Helper;

public interface IHelper {

    public abstract Object obterModelo();
    public abstract void limparTela();
}
```
 </details>

 <details>
<summary>Login</summary>
```ruby
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.Controller.Helper;

import com.barbearia.Model.Cliente;
import com.barbearia.Model.Usuario;
import com.barbearia.View.Login;

/**
 *
 * @author JOÃO
 */
public class LoginHelper implements IHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    @Override
    public Usuario obterModelo(){
        String nome = view.getTextUsuarioInput().getText();
        String senha = view.getTextSenha().getText();
        Usuario modelo = new Cliente("0", nome, senha);
        return modelo;
    }
  
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuarioInput();
        view.getTextSenha().setText(senha);
    }
    @Override
    public void limparTela(){
        view.getTextUsuarioInput().setText("");
        view.getTextSenha().setText("");
    }
}
```  
 </details>

3. Criando os Views

<details>
<summary>Agenda</summary>
```ruby
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

import com.barbearia.Controller.AgendaController;

import javax.swing.*;

/**
 *
 * @author JOÃO
 */
public class Agenda extends javax.swing.JFrame {
    private final AgendaController controller;
    private JTable TableAgendamentos;
    private JComboBox<String> jComboBoxCliente;
    private JComboBox<String> jComboBoxServico;
    private JTextField TextValor;
    private JFormattedTextField TextFormatedData;
    private JFormattedTextField TextFormatedHora;
    private JTextField TextId;
    private JTextArea TextObservacao;
    /**
     * Creates new form Agenda
     */
    public Agenda() {
        initComponents();
        controller = new AgendaController(this);
        iniciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textArea_Observacoes = new java.awt.TextArea();
        jComboBox1_Clientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 220, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Serviço", "Colaborador", "Data", "Hora", "Observação"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 990, 160));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Agenda");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 30, 150, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observações");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor R$");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 30));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hora");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 386, 30, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 40, 30));

        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 220, 30));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 220, 30));

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 322, 220, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Serviço");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 206, 50, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 40, 30));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Agendar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 470, 40));
        getContentPane().add(textArea_Observacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 470, 250));

        jComboBox1_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funalo", "Ciclano", "Beltrano", "Alguém" }));
        getContentPane().add(jComboBox1_Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 220, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 30, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 62, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoAgenda.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox1_Clientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private java.awt.TextArea textArea_Observacoes;
    // End of variables declaration//GEN-END:variables

    public void setTableAgendamentos(JTable TableAgendamentos) {
        this.TableAgendamentos = TableAgendamentos;
    }
    public JTable getTableAgendamentos() {
        return TableAgendamentos;
    }
    public JComboBox<String> getjComboBoxCliente() {
        return jComboBoxCliente;
    }
    public void setjComboBoxCliente(JComboBox<String> jComboBoxCliente) {
        this.jComboBoxCliente = jComboBoxCliente;
    }
    public JComboBox<String> getjComboBoxServico() {
        return jComboBoxServico;
    }
    public void setjComboBoxServico(JComboBox<String> jComboBoxServico) {
        this.jComboBoxServico = jComboBoxServico;
    }
    public JTextField getTextValor() {
        return TextValor;
    }
    public void setTextValor(JTextField TextValor) {
        this.TextValor = TextValor;
    }
    public JFormattedTextField getTextFormatedData() {
        return TextFormatedData;
    }
    public void setTextFormatedData(JFormattedTextField TextFormatedData) {
        this.TextFormatedData = TextFormatedData;
    }
    public JFormattedTextField getTextFormatedHora() {
        return TextFormatedHora;
    }
    public void setTextFormatedHora(JFormattedTextField TextFormatedHora) {
        this.TextFormatedHora = TextFormatedHora;
    }
    public JTextField getTextId() {
        return TextId;
    }
    public void setTextId(JTextField TextId) {
        this.TextId = TextId;
    }
    public JTextArea getTextObservacao() {
        return TextObservacao;
    }
    public void setTextObservacao(JTextArea TextObservacao) {
        this.TextObservacao = TextObservacao;
    }
    private void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}
``` 
</details>

<details>
<summary>Login</summary>
```ruby
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

import com.barbearia.Controller.LoginController;
import com.barbearia.Model.DAO.Banco;

import javax.swing.*;

/**
 *
 * @author JOÃO
 */
public class Login extends javax.swing.JFrame {

    private final LoginController controller;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        controller = new LoginController(this);
        Banco.inicia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        textUsuarioInput = new javax.swing.JTextArea();
        textSenha = new javax.swing.JPasswordField();
        jLabel4_usuario = new javax.swing.JLabel();
        jLabel5_senha = new javax.swing.JLabel();
        jLabel2_login = new javax.swing.JLabel();
        jLabel3_painelLogin = new javax.swing.JLabel();
        jLabel1_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 460, 330, -1));

        textUsuarioInput.setColumns(20);
        textUsuarioInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textUsuarioInput.setRows(5);
        getContentPane().add(textUsuarioInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 330, 30));

        textSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textSenha.setText("jPasswordField1");
        textSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 330, 30));

        jLabel4_usuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4_usuario.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_usuario.setText("Usuário");
        getContentPane().add(jLabel4_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 330, 40));

        jLabel5_senha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5_senha.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5_senha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_senha.setText("Senha");
        getContentPane().add(jLabel5_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 330, 40));

        jLabel2_login.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2_login.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_login.setText("Login");
        getContentPane().add(jLabel2_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 330, 50));

        jLabel3_painelLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/painel2.png"))); // NOI18N
        getContentPane().add(jLabel3_painelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel1_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoDesenho.jpg"))); // NOI18N
        jLabel1_fundo.setText("Login");
        getContentPane().add(jLabel1_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 599, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    } 
    private void textSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSenhaActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.controller.entrarNoSistema();
     
               
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1_fundo;
    private javax.swing.JLabel jLabel2_login;
    private javax.swing.JLabel jLabel3_painelLogin;
    private javax.swing.JLabel jLabel4_usuario;
    private javax.swing.JLabel jLabel5_senha;
    private javax.swing.JPasswordField textSenha;
    private javax.swing.JTextArea textUsuarioInput;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param mensagem
     */
    public void exibeMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void setTextSenha(JPasswordField textSenha) {
        this.textSenha = textSenha;
    }
    public void setTextUsuarioInput(JTextArea textUsuarioInput) {
        this.textUsuarioInput = textUsuarioInput;
    }
    public JPasswordField getTextSenha() {
        return textSenha;
    }
    public JTextArea getTextUsuarioInput() {
        return textUsuarioInput;
    }
    public JLabel getjLabel4_usuario() {
        return jLabel4_usuario;
    }
    public JLabel getjLabel5_senha() {
        return jLabel5_senha;
    }
     
}
``` 
</details>

<details>
<summary>Menu Principal</summary>
```ruby
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

import com.barbearia.Controller.MenuPrincipalController;

/**
 *
 * @author JOÃO
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final MenuPrincipalController controller;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.controller = new MenuPrincipalController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuOperacao = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoMenuPrincipal.jpg"))); // NOI18N

        jMenuCadastro.setText("Cadastro");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/clienteIcon.png"))); // NOI18N
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/iconServico.png"))); // NOI18N
        jMenuItem2.setText("Serviço");
        jMenuCadastro.add(jMenuItem2);

        jMenuBar1.add(jMenuCadastro);

        jMenuOperacao.setText("Operação");
        jMenuBar1.add(jMenuOperacao);

        jMenu1.setText("Relatório");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void MenuItemClienteActionPerformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
    }
    private void MenuItemRelatorioActionsperformed(java.awt.event.ActionEvent evt){
        // TODO add your handling code here:
    }
    private void MenuItemAgendaActionPerformed(java.awt.event.ActionEvent evt){
        this.controller.navegarParaAgenda();
    }

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMenuOperacao;
    // End of variables declaration//GEN-END:variables
}
``` 
</details>

4. Criando as Classes

<details>
<summary>Agendamento</summary>
```ruby
package com.barbearia.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {

    private int idAgendamento;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date dataAgendamento;
    private String observacao;

    public Agendamento(int idAgendamento, Cliente cliente, Servico servico, float valor, String dataAgendamento) {
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.dataAgendamento = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataAgendamento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public Agendamento() {
    }
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String dataHora, String observacao) {
    }
    public int getIdAgendamento() {
        return idAgendamento;
    }
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Date getDataAgendamento() {
        return dataAgendamento;
    }
    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
```
</details>

<details>
<summary>Cliente</summary>
```ruby
package com.barbearia.Model;

public class Cliente extends Usuario {
    public Cliente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
    private float saldo;
    private Plano plano;
}
```
</details>

<details>
<summary>Colaborador</summary>
```ruby
package com.barbearia.Model;

class Colaborador extends Usuario {
    private String nivelAcesso;

    public Colaborador(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
}
```
</details>

<details>
<summary>Endereço</summary>
```ruby
package com.barbearia.Model;

class Endereco {

}
```
</details>

<details>
<summary>Plano</summary>
```ruby
package com.barbearia.Model;

public class Plano {

}
```
</details>

<details>
<summary>Serviço</summary>
```ruby
package com.barbearia.Model;

import javax.swing.*;

public class Servico {

    private int id;
    private String descricao;
    private float valor;

    public Servico(int id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
    public Servico(float valor) {
        this.valor = valor;
    }
    public Servico() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}
```
</details>

<details>
<summary>Usuário</summary>
```ruby
package com.barbearia.Model;

import com.barbearia.Model.DAO.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Usuario {
    DAO dao = new DAO();
    private Connection con;

    private int id;

    private String senha;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Date dataNascimento;
    public Usuario(int id, String cpf, String nome, String senha ,String telefone, String email, Endereco endereco, String dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        ;
    }

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
    public int getId() {
        return id;
    }
    public String getSenha() {
        return senha;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public Connection getCon() {
        return con;
    }
    //Instancia que retorna se conectou ao banco de dados as informações inseridas.
    private void status(){
        try {
            if (con == null){
                System.out.println("Erro de coneção");
            } else {
                System.out.println("Banco de dados conectado");
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

```
</details>
 
5. Criando as Classes DAO
   
<details>
<summary>DAO</summary>
```ruby
package com.barbearia.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306";
    private String user = "root";
    private String password = "root";

    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
```
</details>

<details>
<summary>Agendamento</summary>
```ruby
package com.barbearia.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {

    private int idAgendamento;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date dataAgendamento;
    private String observacao;

    public Agendamento(int idAgendamento, Cliente cliente, Servico servico, float valor, String dataAgendamento) {
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.dataAgendamento = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataAgendamento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public Agendamento() {
    }
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String dataHora, String observacao) {
    }
    public int getIdAgendamento() {
        return idAgendamento;
    }
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Date getDataAgendamento() {
        return dataAgendamento;
    }
    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
``` 
</details>

<details>
<summary>Banco</summary>
```ruby
package com.barbearia.Model.DAO;

import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.Servico;
import com.barbearia.Model.Usuario;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Usuario> usuario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;
    public static void inicia(){
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<Cliente>();
        servico = new ArrayList<Servico>();
        agendamento = new ArrayList<Agendamento>();
    }
}
``` 
</details>

<details>
<summary>Clientes</summary>
```ruby
package com.barbearia.Model;

public class Cliente extends Usuario {
    public Cliente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
    private float saldo;
    private Plano plano;

}
``` 
</details>

<details>
<summary>Colaboradores</summary>
```ruby

package com.barbearia.Model.DAO;

public class ColaboradorDAO {
}
``` 
</details>

<details>
<summary>Serviço</summary>
```ruby
package com.barbearia.Model.DAO;

import com.barbearia.Model.Servico;
import java.util.ArrayList;

public class ServicoDAO {
    public void insert(Servico servico){
        Banco.servico.add(servico);
    }
    private boolean idSaoIguais(Servico servico, Servico servicoAComparar) {
        return servico.getId() ==  servicoAComparar.getId();
    }
    public boolean update(Servico servico){

        for (int i = 0; i < Banco.servico.size(); i++) {
            if(idSaoIguais(Banco.servico.get(i),servico)){
                Banco.servico.set(i, servico);
                return true;
            }
        }
        return false;
    }
    public boolean delete(Servico servico){
        for (Servico servicoLista : Banco.servico) {
            if(idSaoIguais(servicoLista,servico)){
                Banco.servico.remove(servicoLista);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Servico> selectAll(){
        return Banco.servico;
    }
}
``` 
</details>

<details>
<summary>Usuário</summary>
```ruby

package com.barbearia.Model.DAO;

import com.barbearia.Model.Usuario;
import java.util.ArrayList;
public class UsuarioDAO {

    public void insert(Usuario usuario){
        Banco.usuario.add(usuario);
    }
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }
    public boolean update(Usuario usuario){

        for (int i = 0; i < Banco.usuario.size(); i++) {
            if(idSaoIguais(Banco.usuario.get(i),usuario)){
                Banco.usuario.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> selectAll(){
        return Banco.usuario;
    }
    private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getNome().equals(usuarioAPesquisar.getNome()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }
    public Usuario selectPorNomeESenha(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(nomeESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        return null;
    }
}
``` 
</details>

6. Criando Serviços

<details>
<summary>Correio</summary>
```ruby
package com.barbearia.Servico;

public class Correio {
}
``` 
</details>

<details>
<summary>E-mail</summary>
```ruby

package com.barbearia.Servico;

public class Email {
}
``` 
</details>

7. Criando o Banco de Dados

<details>
<summary>Agenda</summary>
```ruby
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

/**
 *
 * @author JOÃO
 */
public class Agenda extends javax.swing.JFrame {

    /**
     * Creates new form Agenda
     */
    public Agenda() {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textArea_Observacoes = new java.awt.TextArea();
        jComboBox1_Clientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 220, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Serviço", "Colaborador", "Data", "Hora", "Observação"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 990, 160));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Agenda");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 30, 150, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observações");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor R$");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hora");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 30, -1));

        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 220, 30));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 220, 30));

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 322, 220, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Serviço");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Agendar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 470, 40));
        getContentPane().add(textArea_Observacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 470, 250));

        jComboBox1_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funalo", "Ciclano", "Beltrano", "Alguém" }));
        getContentPane().add(jComboBox1_Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 220, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 30, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 62, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/fundoAgenda.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox1_Clientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private java.awt.TextArea textArea_Observacoes;
    // End of variables declaration//GEN-END:variables
}
```
</details>

<details>
<summary>Login</summary>
```ruby

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
```
</details>

<details>
<summary>Menu Principal</summary>
```ruby

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.barbearia.View;

/**
 *
 * @author JOÃO
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuOperacao = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/fundoMenuPrincipal.jpg"))); // NOI18N

        jMenuCadastro.setText("Cadastro");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/icons/clienteIcon.png"))); // NOI18N
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/barbearia/View/imagens/icons/iconServico.png"))); // NOI18N
        jMenuItem2.setText("Serviço");
        jMenuCadastro.add(jMenuItem2);

        jMenuBar1.add(jMenuCadastro);

        jMenuOperacao.setText("Operação");
        jMenuBar1.add(jMenuOperacao);

        jMenu1.setText("Relatório");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMenuOperacao;
    // End of variables declaration//GEN-END:variables
}
```
</details>
***

## Organização

Para realização do Projeto, o grupo se reunião, através do whatsApp, para levantar algumas ideias de projetos, dentre elas: desenvolvimento de um sistema de precificação e controle de estoque para comércios; desenvolver uma rede de prestadores de serviços de uma determinada região para que usuários cadastrados possam entrar em contato e contratar serviços de profissionais registrados na plataforma; e desenvolver um sistema para uma barbearia onde os clientes podem fazer assinaturas de planos, fazer agendamentos e o proprietário tenha mais controle de seus colaboradores e ter um mural de patrocinadores. Depois de discutido entre os participantes do grupo, foi escolhida a última ideia de projeto. 
*** 

## Dificuldades Conhecidas

Como trazer inovação tecnológica a fim de modernizar a gestão, controle e ideias de negócio para este empreendimento. 
***

## Desenvolvedores do projeto

| [<img src="https://media.licdn.com/dms/image/D4D35AQFVgxB9h8CBIw/profile-framedphoto-shrink_400_400/0/1698000832541?e=1716688800&v=beta&t=GQ_GUAH6hngNaD17SXrXRYXMPQVrMUucB5TSUdIlJzE" width=115><br><sub>Bruna Tokuno</sub>](https://www.linkedin.com/in/bruna-tokuno-de-sousa-312802170?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app) | [<img src="https://avatars.githubusercontent.com/u/51243178?v=4" width=115><br><sub>Gabriel Santos</sub>](https://github.com/GabrielSantos10) | [<img src="https://avatars.githubusercontent.com/u/124359272?v=4" width=115><br><sub>Irati Maffra</sub>](https://github.com/IratiMaffra) | [<img src="https://avatars.githubusercontent.com/u/163658340?v=4" width=115><br><sub>Jediael Ferreira</sub>](https://github.com/Jedi-Ferreira) | [<img src="https://avatars.githubusercontent.com/u/83663822?v=4" width=115><br><sub>João Donato</sub>](https://github.com/DonatoJoao) | [<img src="https://avatars.githubusercontent.com/u/170274099?v=4" width=115><br><sub>Lays Motta</sub>](https://github.com/LaysMotta) | [<img src="https://avatars.githubusercontent.com/u/88247357?v=4" width=115><br><sub>Sandro Alves Jr.</sub>](https://github.com/SandroAlvez) | [<img src="https://media.licdn.com/dms/image/D4D03AQHigoFkbveHVA/profile-displayphoto-shrink_400_400/0/1701190953083?e=1721260800&v=beta&t=2i4rKOqXNAIQ9G01f1y5JeCWxbh61dSu1i1Rj7fNeTE" width=115><br><sub>Thiago Lourenço</sub>](https://www.linkedin.com/in/thiago-louren%C3%A7o-b166041b1?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app) |
| :---: | :---: | :---: | :---: | :---: | :---: |:---: | :---: |

