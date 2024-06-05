package Trasacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrasacaoDAO {
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

    public List<Transacao> getAllTransacoes() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String query = "SELECT * FROM TRANSACAO";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(rs.getInt("ID_TRANSACAO"));
                transacao.setData(rs.getDate("DATA"));
                transacao.setValor(rs.getDouble("VALOR"));
                transacao.setContaNrConta(rs.getString("CONTA_NR_CONTA"));
                transacoes.add(transacao);
            }
        }

        return transacoes;
    }

    public void insertTransacao(Transacao transacao) throws SQLException {
        String query = "INSERT INTO TRANSACAO (ID_TRANSACAO, DATA, VALOR, CONTA_NR_CONTA) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setDate(2, transacao.getData());
            stmt.setDouble(3, transacao.getValor());
            stmt.setString(4, transacao.getContaNrConta());
            stmt.executeUpdate();
        }
    }
}
