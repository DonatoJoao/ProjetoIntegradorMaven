package com.barbearia.Model;

public class Cliente extends Usuario {
    public Cliente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }


    private float saldo;
    private Plano plano;



}
