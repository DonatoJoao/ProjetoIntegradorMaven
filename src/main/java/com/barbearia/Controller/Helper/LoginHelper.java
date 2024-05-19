/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.Controller.Helper;

import com.barbearia.View.Login;
import javax.swing.JPasswordField;

/**
 *
 * @author JOÃO
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = null;
    }
    public Usuario obterModelo(){
        String nome = view.getTextUsuarioInput().getText();
        String senha = String.valueOf(view.getTextSenha());
        Usuario modelo = new Usuario(0, nome, senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextUsuarioInput();
        view.getTextSenha().setText(senha);
    }
    public void limparTela(){
        view.getTextUsuarioInput().setText("");
        view.getTextSenha().setText("");
    }

}