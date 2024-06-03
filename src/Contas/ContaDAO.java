package classes.ContaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ContaDAO {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "João_Silva";
    private static final String PASSWORD = "Silvajoão";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Conta> getAllContas() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        String query = "SELECT * FROM Conta";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setNrConta(rs.getString("1234"));
                conta.setTpConta(rs.getString("Física"));
                conta.setSaldo(rs.getDouble("R$ 5.000,00"));
                conta.setIdCliente(rs.getInt("Cliente_id_cliente"));
                contas.add(conta);
            }
        }

        return contas;
    }

    public void insertConta(Conta conta) throws SQLException {
        String query = "INSERT INTO Conta (nr_conta, tp_conta, saldo, Cliente_id_cliente) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, conta.getNrConta());
            stmt.setString(2, conta.getTpConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setInt(4, conta.getIdCliente());
            stmt.executeUpdate();
        } // Added the missing closing curly brace here
    }
}

