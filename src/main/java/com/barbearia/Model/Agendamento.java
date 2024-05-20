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
