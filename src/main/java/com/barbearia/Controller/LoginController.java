package com.barbearia.Controller;

import com.barbearia.Controller.Helper.LoginHelper;
import com.barbearia.Model.DAO.UsuarioDAO;
import com.barbearia.Model.Usuario;
import com.barbearia.View.Login;
import com.barbearia.View.MenuPrincipal;

public class LoginController {
    private final Login view;
    private LoginHelper helper;
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    //Toda lógica/regras de negócio deverá estar aqui

    public void entrarNoSistema(){
        //Pegar usuario da View
        Usuario usuario = helper.obterModelo();
        //Pesquisa usuario no Banco
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
