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
