package Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class ClienteDAO {

    public Connection getConnection() throws SQLException {
        return new Conexao().getConnection();
    }

    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_CLIENTE")); // Substitua "ID_CLIENTE" pelo nome correto da coluna do ID
                cliente.setNome(rs.getString("NOME")); // Substitua "NOME" pelo nome correto da coluna do Nome
                cliente.setEndereco(rs.getString("ENDERECO")); // Substitua "ENDERECO" pelo nome correto da coluna do Endereço
                cliente.setEmail(rs.getString("EMAIL")); // Substitua "EMAIL" pelo nome correto da coluna do Email
                cliente.setInfoContato(rs.getString("INFO_CONTATO")); // Substitua "INFO_CONTATO" pelo nome correto da coluna da Informação de Contato
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
