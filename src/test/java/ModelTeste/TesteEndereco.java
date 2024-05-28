package ModelTeste;

import com.barbearia.Model.Cliente;
import com.barbearia.Model.Endereco;

public class TesteEndereco {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        cliente.setEndereco(endereco);
        endereco.setBairro("Cibratel");
        endereco.setCidade("Itanhaém");
        endereco.setCep("11740-000");
        System.out.println(cliente.getEndereco().getCep());
        System.out.println(cliente.getEndereco().getCidade());
        Cliente clienteJoao = new Cliente();
        Endereco enderecoJoao = new Endereco();
        clienteJoao.setEndereco(enderecoJoao);

        enderecoJoao.setBairro("Centro");
        System.out.println(clienteJoao.getEndereco().getBairro());

    }
}
