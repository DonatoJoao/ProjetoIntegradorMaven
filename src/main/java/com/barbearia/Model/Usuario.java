package com.barbearia.Model;

import java.util.Date;

abstract class Usuario {
    private int id;
    private String senha;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Date dataNascimento;

    public Usuario(int id, String cpf, String nome, String senha ,String telefone, String email, Endereco endereco, Date dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
}
class Cliente extends  Usuario{
    private float saldo;
    private Plano plano;


}
class Colaborador extends Usuario{
        private String nivelAcesso;
}

