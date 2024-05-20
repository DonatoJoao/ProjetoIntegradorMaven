package ModelTeste;

import com.barbearia.Model.Servico;

public class TesteServico {

    public static void main(String[] args) {
        Servico servico = new Servico(1,"Corte", 15);
        System.out.println(servico.getId());
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
    }


}
