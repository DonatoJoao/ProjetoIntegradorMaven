package ModelTeste;

import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.Servico;

public class TesteAgendamento {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12345678999", "João", "1234" );
        Servico corteCabelo = new Servico(30);
        corteCabelo.setDescricao("Corte Simples");

        Agendamento agendamento = new Agendamento(1, cliente, corteCabelo, 30, "20/05/2024 18:00" );
        System.out.println("Serviço agendado por: " + agendamento.getCliente().getNome() +
                ", serviço: " + agendamento.getServico().getDescricao() +
                ", na data: " + agendamento.getDataAgendamento() +
                " com valor de: "+ agendamento.getServico().getValor() + " Reais"
        );


//        System.out.println(agendamento.getCliente().getNome());
//        System.out.println(agendamento.getServico().getValor());
//        System.out.println(agendamento.getServico().getDescricao());

    }
}
