package Trasacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class TrasacaoDAO {

    public List<Transacao> getAllTransacoes() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String query = "SELECT * FROM TRANSACAO";

        try (Connection conn = new Conexao().getConnection(); // Obtém a conexão utilizando o método da classe de conexão
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

        try (Connection conn = new Conexao().getConnection(); // Obtém a conexão utilizando o método da classe de conexão
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setDate(2, transacao.getData());
            stmt.setDouble(3, transacao.getValor());
            stmt.setString(4, transacao.getContaNrConta());
            stmt.executeUpdate();
        }
    }
}
