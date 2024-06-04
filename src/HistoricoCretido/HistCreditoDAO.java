package HistoricoCretido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistCreditoDAO {
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

    public List<HistCredito> getAllHistCredito() throws SQLException {
        List<HistCredito> histCreditoList = new ArrayList<>();
        String query = "SELECT * FROM HIST_CREDITO";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HistCredito histCredito = new HistCredito();
                histCredito.setIdHistCredito(rs.getInt("ID_HIST_CREDITO"));
                histCredito.setDadosRelacionados(rs.getString("DADOS_RELACIONADOS"));
                histCredito.setIdCliente(rs.getInt("CLIENTE_ID_CLIENTE"));
                histCreditoList.add(histCredito);
            }
        }
        return histCreditoList;
    }

    public void insertHistCredito(HistCredito histCredito) throws SQLException {
        String query = "INSERT INTO Hist_Credito (id_hist_credito, dados_relacionados, Cliente_id_cliente) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, histCredito.getIdHistCredito());
            stmt.setString(2, histCredito.getDadosRelacionados());
            stmt.setInt(3, histCredito.getIdCliente());
            stmt.executeUpdate();
        } // Chave de fechamento adicionada
    }
}
