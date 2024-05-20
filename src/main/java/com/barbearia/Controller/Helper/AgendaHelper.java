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
