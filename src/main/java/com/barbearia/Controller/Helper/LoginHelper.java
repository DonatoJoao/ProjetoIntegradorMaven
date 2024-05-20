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
