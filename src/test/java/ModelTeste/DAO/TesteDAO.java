package ModelTeste.DAO;

import com.barbearia.Model.Cliente;
import com.barbearia.Model.DAO.DAO;

public class TesteDAO {
        public static void main(String[] args) {

            Cliente cliente = new Cliente("123456789", "João", "1234");
            new DAO().cadastrar(cliente); //armazenou dados no banco

        }
}
