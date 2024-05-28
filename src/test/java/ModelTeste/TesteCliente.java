package ModelTeste;

import com.barbearia.Model.Cliente;



public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("12345678999", "João", "1234");
        System.out.println(cliente.getSenha());
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Pri");
        System.out.println(cliente2.getNome());
        System.out.println(cliente2.getSenha());
        Cliente cliente3 = new Cliente("123456789", "Fulano", "abcd");
        System.out.println(cliente3.getCpf());



    }
}
