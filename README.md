# Projeto Integrador I - Univesp
###  A Proposta do nosso projeto é...
***
<div align="center">
 <img src= "C:\Users\igmf5\Documents\GitHub\UNIVESP\barbearia.jpg" alt="capa github" 
  width="450"/>
</div>



***
 
## Introdução 

Desenvolver uma aplicação web utilizando linguagem de programação JAVA, um framework, banco de dados e controle de versionamento com GitHub.



****

## Objetivo

Desenvolver um sistema para: gerar controle de colaboradores, cadastro de clientes, planos de assinaturas e agendamentos.
***

## Arquitetura

![arquitetura](C:\Users\igmf5\Documents\GitHub\UNIVESP\arquitetura.jpg)

***
## Funcionamento 

...

Deverá seguir esses passos: 

1. Criando as classes
<details>
<summary>**Agendamento**</summary>

```bash
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
```
**Cliente**

```bash
package com.barbearia.Model;

public class Cliente extends Usuario {
    public Cliente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }

    private float saldo;
    private Plano plano;

}
```
**Colaborador**

```bash
package com.barbearia.Model;

class Colaborador extends Usuario {
    private String nivelAcesso;

    public Colaborador(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
}
```
**Endereço**

```bash
package com.barbearia.Model;

class Endereco {

}
```
**Plano**

```bash
package com.barbearia.Model;

public class Plano {


}
```
**Serviço**

```bash
package com.barbearia.Model;

import javax.swing.*;

public class Servico {

    private int id;
    private String descricao;
    private float valor;

    public Servico(int id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(float valor) {
        this.valor = valor;
    }

    public Servico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
```
**Usuário**

```bash
package com.barbearia.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Usuario(int id, String cpf, String nome, String senha ,String telefone, String email, Endereco endereco, String dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy ").parse(dataNascimento);
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
}
```

```bash

```

...

2. ...

...
3. ...

...

****
## Organização

Para realização do Projeto, o grupo se reunião, através do whatsApp, para levantar algumas ideias de projetos, dentre elas: desenvolvimento de um sistema de precificação e controle de estoque para comércios; desenvolver uma rede de prestadores de serviços de uma determinada região para que usuários cadastrados possam entrar em contato e contratar serviços de profissionais registrados na plataforma; e desenvolver um sistema para uma barbearia onde os clientes podem fazer assinaturas de planos, fazer agendamentos e o proprietário tenha mais controle de seus colaboradores e ter um mural de patrocinadores. Depois de discutido entre os participantes do grupo, foi escolhida a última ideia de projeto. 

*** 

## Dificuldades Conhecidas

Como trazer inovação tecnológica a fim de modernizar a gestão, controle e ideias de negócio para este empreendimento. 



***
## Desenvolvedores do projeto

| [<img src="https://avatars.githubusercontent.com/u/170149114?v=4" width=115><br><sub>Bruna Tokuno de Sousa</sub>](https://github.com/bru-tokuno) | [<img src="https://avatars.githubusercontent.com/u/51243178?v=4" width=115><br><sub>Gabriel Santos Silva</sub>](https://github.com/GabrielSantos10) | [<img src="https://avatars.githubusercontent.com/u/124359272?v=4" width=115><br><sub>Irati Gonçalves Maffra</sub>](https://github.com/IratiMaffra) | [<img src="https://avatars.githubusercontent.com/u/163658340?v=4" width=115><br><sub>Jediael da Silva Ferreira</sub>](https://github.com/Jedi-Ferreira) | [<img src="https://avatars.githubusercontent.com/u/83663822?v=4" width=115><br><sub>João Donato de Morais Pereira</sub>](https://github.com/DonatoJoao) | [<img src="" width=115><br><sub>Lays Motta de Albuquerque Lourenço</sub>](https://github.com/Lays) | [<img src="" width=115><br><sub>Sandro Roberto Alves Júnior</sub>](https://github.com/sandro) | [<img src="https://media.licdn.com/dms/image/D4D03AQHigoFkbveHVA/profile-displayphoto-shrink_400_400/0/1701190953083?e=1721260800&v=beta&t=2i4rKOqXNAIQ9G01f1y5JeCWxbh61dSu1i1Rj7fNeTE" width=115><br><sub>Thiago Lourenço Sales</sub>](https://www.linkedin.com/in/thiago-louren%C3%A7o-b166041b1?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app) |
| :---: | :---: | :---: | :---: | :---: | :---: |:---: | :---: |

