package com.barbearia.Model.DAO.Refatorar;

import com.barbearia.Model.Agendamento;

import java.util.ArrayList;

public class AgendamentoDAO {

    public void insert(Agendamento agendamento){
        if (agendamento.getIdAgendamento() == 0){
            agendamento.setIdAgendamento(proximoId());
            Banco.agendamento.add(agendamento);
        }

    }
    private boolean idSaoIguais(Agendamento agendamento, Agendamento agendamentoAComparar){
        return agendamento.getIdAgendamento() == agendamentoAComparar.getIdAgendamento();
    }
    public boolean update(Agendamento agendamento){
        for (int i = 0; i < Banco.agendamento.size(); i++) {
            if (idSaoIguais(Banco.agendamento.get(i),agendamento)){
                Banco.agendamento.set(i, agendamento);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Agendamento agendamento){
        for (Agendamento agendamentoLista: Banco.agendamento) {
            if (idSaoIguais(agendamentoLista,agendamento)){
                Banco.agendamento.remove(agendamentoLista);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Agendamento> selectAll(){
        return Banco.agendamento;
    }

    private int proximoId(){
        int maiorId = 0;
        for (Agendamento agendamento : Banco.agendamento){
            int id = agendamento.getIdAgendamento();
            if (maiorId < id){
                maiorId = id;
            }
        }
        return maiorId + 1;
    }
}
