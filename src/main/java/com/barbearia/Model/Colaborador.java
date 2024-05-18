package com.barbearia.Model;

class Colaborador extends Usuario {
    private String nivelAcesso;

    public Colaborador(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
}
