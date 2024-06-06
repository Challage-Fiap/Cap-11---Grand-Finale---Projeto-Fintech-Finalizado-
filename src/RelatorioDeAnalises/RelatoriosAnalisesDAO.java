package RelatorioDeAnalises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class RelatoriosAnalisesDAO {

    public List<RelatoriosAnalises> getAllRelatoriosAnalises() throws SQLException {
        List<RelatoriosAnalises> relatoriosAnalisesList = new ArrayList<>();
        String query = "SELECT * FROM Relatorios_Analises";

        try (Connection conn = new Conexao().getConnection(); // Cria uma nova instância de Conexao e obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RelatoriosAnalises relatorioAnalise = new RelatoriosAnalises();
                relatorioAnalise.setIdRelatorioAnalise(rs.getInt("ID_RELATORIO_ANALISE"));
                relatorioAnalise.setDadosAnalisesRelatorios(rs.getString("DADOS_ANALISES_RELATORIOS"));
                relatorioAnalise.setIdCliente(rs.getInt("CLIENTE_ID_CLIENTE"));
                relatoriosAnalisesList.add(relatorioAnalise);
            }
        } catch (SQLException e) {
            // Adicione uma mensagem de erro ou log
            System.err.println("Erro ao buscar Relatorios_Analises: " + e.getMessage());
            throw e;
        }

        return relatoriosAnalisesList;
    }

    public void insertRelatorioAnalise(RelatoriosAnalises relatorioAnalise) throws SQLException {
        String query = "INSERT INTO Relatorios_Analises (id_relatorio_analise, dados_analises_relatorios, Cliente_id_cliente) VALUES (?, ?, ?)";

        try (Connection conn = new Conexao().getConnection(); // Cria uma nova instância de Conexao e obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, relatorioAnalise.getIdRelatorioAnalise());
            stmt.setString(2, relatorioAnalise.getDadosAnalisesRelatorios());
            stmt.setInt(3, relatorioAnalise.getIdCliente());
            stmt.executeUpdate();
        }
    }
}
