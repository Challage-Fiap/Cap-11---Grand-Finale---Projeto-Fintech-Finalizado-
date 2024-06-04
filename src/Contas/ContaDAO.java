package Contas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ContaDAO {
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

    public List<Conta> getAllContas() throws SQLException {
        List<Conta> contas = new ArrayList<>();
        String query = "SELECT * FROM Conta";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setNrConta(rs.getString("NR_CONTA"));
                conta.setTpConta(rs.getString("TP_CONTA"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setIdCliente(rs.getInt("CLIENTE_ID_CLIENTE"));
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

