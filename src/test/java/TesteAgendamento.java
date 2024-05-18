import com.barbearia.Model.Agendamento;
import com.barbearia.Model.Cliente;
import com.barbearia.Model.Servico;

public class TesteAgendamento {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12345678999", "João", "1234" );
        Servico corteCabelo = new Servico(30);

        Agendamento agendamento = new Agendamento(1, cliente, corteCabelo, 30, "20/05/2024 18:00" );
        System.out.println(agendamento.getDataAgendamento());
        System.out.println(agendamento.getCliente().getNome());
        System.out.println(agendamento.getServico().getValor());

    }
}
