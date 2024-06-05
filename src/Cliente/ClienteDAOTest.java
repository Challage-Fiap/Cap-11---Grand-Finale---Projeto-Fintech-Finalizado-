package Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOTest {
    public static void testGetAllClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            if (clientes != null && clientes.size() > 0) {
                System.out.println("Teste de getAllClientes passou.");
            } else {
                System.out.println("Teste de getAllClientes falhou: Nenhum cliente retornado.");
            }
        } catch (SQLException e) {
            System.out.println("Teste de getAllClientes falhou: " + e.getMessage());
        }
    }

    public static void testInsertCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1001); // id
        cliente.setNome("Teste");
        cliente.setEndereco("Endereço de teste");
        cliente.setEmail("teste@teste.com");
        cliente.setInfoContato("9999-9999");

        try {
            clienteDAO.insertCliente(cliente);
            System.out.println("Teste de insertCliente passou.");
        } catch (SQLException e) {
            System.out.println("Teste de insertCliente falhou: " + e.getMessage());
        }
    }
}
