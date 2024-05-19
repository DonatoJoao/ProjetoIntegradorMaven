package com.barbearia.Controller;

import com.barbearia.View.Login;

public class LoginController {
    private final Login view;
    public LoginController(Login view) {
        this.view = view;
    }

    //Toda lógica/regras de negócio deverá estar aqui

    public void entrarNoSistema(){
        //Pegar usuario da View
        //Pesquisa usuario no Banco
        //Verificar se usuario da view tiver banco
        
        
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo");
        this.view.exibeMensagem("Executei tarefa");
    }


}
