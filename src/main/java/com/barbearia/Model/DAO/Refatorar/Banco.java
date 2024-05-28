package com.barbearia.Model.DAO.Refatorar;

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
        
        Usuario usuario1 = new Usuario("123456789", "joao", "1234");
        Usuario usuario2 = new Usuario(1,"33333333","pri", "1234", "34223536", "pri@pri.com", null, "11/08/1992" );
         
        Cliente cliente1 = new Cliente();
        
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente();
        Cliente cliente5 = new Cliente();
        Cliente cliente6 = new Cliente();
        Cliente cliente7 = new Cliente();
        Cliente cliente8 = new Cliente();
        Cliente cliente9 = new Cliente();
        Cliente cliente10 = new Cliente();
        
        Servico servico1 = new Servico(1, "Corte Simples", 18);
        Servico servico2 = new Servico(2, "Corte Degrade", 30);
        Servico servico3 = new Servico(3, "Barba Simples", 15);
        Servico servico4 = new Servico(4, "Barba Desenhada", 25);
        Servico servico5 = new Servico(5, "Sombrancelhas", 10);
        Servico servico6 = new Servico(6, "Penteados", 3);

        Agendamento agendamento1 = new Agendamento(1, cliente1, servico2, 30, "14/07/2018 09:30");
        Agendamento agendamento2 = new Agendamento(2, cliente3, servico4, 40, "14/07/2018 10:00");
        Agendamento agendamento3 = new Agendamento(3, cliente4, servico1, 18, "14/07/2018 10:30");
        
        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);
        
        cliente.add(cliente1);
        cliente.add(cliente2);
        cliente.add(cliente3);
        cliente.add(cliente4);
        cliente.add(cliente5);
        cliente.add(cliente6);
        cliente.add(cliente7);
        cliente.add(cliente8);
        cliente.add(cliente9);
        cliente.add(cliente10);
        
        servico.add(servico1);
        servico.add(servico2);
        servico.add(servico3);
        servico.add(servico4);
        servico.add(servico5);
        servico.add(servico6);
        
        agendamento.add(agendamento1);
        agendamento.add(agendamento2);
        agendamento.add(agendamento3);
        
        
        
        
    
        
    }

    

}
