package com.barbearia.Model;
import com.barbearia.Model.DAO.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Usuario {
    //arrumar classe novamente como abstract
    private int id;
    private String senha;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Date dataNascimento;
    public Usuario(int id, String cpf, String nome, String senha ,String telefone, String email, Endereco endereco, String dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        ;
    }
    public Usuario() {
    }
    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
    public int getId() {
        return id;
    }
    public String getSenha() {
        return senha;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }





}

