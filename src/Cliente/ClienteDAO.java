package Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String JDBC_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USERNAME = "RM552828"; // Replace with your username
    private static final String PASSWORD = "300805";  // Replace with your password

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC não foi encontrado!");
            e.printStackTrace();
            throw new SQLException("Failed to get connection: Driver Not Found");
        }
    }
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_CLIENTE")); // Substitua "João_Silva" pelo nome correto da coluna do ID
                cliente.setNome(rs.getString("NOME")); // Substitua "João Silva" pelo nome correto da coluna do Nome
                cliente.setEndereco(rs.getString("ENDERECO")); // Substitua "Av. Paulista, 32" pelo nome correto da coluna do Endereço
                cliente.setEmail(rs.getString("EMAIL")); // Substitua "JoãoSilva@gmail.com" pelo nome correto da coluna do Email
                cliente.setInfoContato(rs.getString("INFO_CONTATO")); // Substitua "(99) 99999-9999" pelo nome correto da coluna da Informação de Contato
                clientes.add(cliente);
            }
        }

        return clientes;
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO Cliente (id_cliente, nome, endereco, email, info_contato) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getInfoContato());
            stmt.executeUpdate();
        }
    }
}
