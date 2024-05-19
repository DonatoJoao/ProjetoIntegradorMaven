package com.barbearia.Model.DAO;

import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.Servico;
import com.barbearia.Model.Usuario;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Cliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;
    public static void inicia(){
        cliente = new ArrayList<Cliente>();
        servico = new ArrayList<Servico>();
        agendamento = new ArrayList<Agendamento>();
    }
}
