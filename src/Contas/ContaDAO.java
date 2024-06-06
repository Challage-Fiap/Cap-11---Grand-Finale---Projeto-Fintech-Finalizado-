package Contas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class ContaDAO {
    public Connection getConnection() throws SQLException {
        return new Conexao().getConnection();
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
        } // Chave de fechamento adicionada
    }
}
