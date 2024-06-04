package RelatorioDeAnalises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosAnalisesDAO {

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

    public List<RelatoriosAnalises> getAllRelatoriosAnalises() throws SQLException {
        List<RelatoriosAnalises> relatoriosAnalisesList = new ArrayList<>();
        String query = "SELECT * FROM Relatorios_Analises";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RelatoriosAnalises relatorioAnalise = new RelatoriosAnalises();
                relatorioAnalise.setIdRelatorioAnalise(rs.getInt("id_relatorio_analise"));
                relatorioAnalise.setDadosAnalisesRelatorios(rs.getString("dados_analises_relatorios"));
                relatorioAnalise.setIdCliente(rs.getInt("Cliente_id_cliente"));
                relatoriosAnalisesList.add(relatorioAnalise);
            }
        }

        return relatoriosAnalisesList;
    }

    public void insertRelatorioAnalise(RelatoriosAnalises relatorioAnalise) throws SQLException {
        String query = "INSERT INTO Relatorios_Analises (id_relatorio_analise, dados_analises_relatorios, Cliente_id_cliente) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, relatorioAnalise.getIdRelatorioAnalise());
            stmt.setString(2, relatorioAnalise.getDadosAnalisesRelatorios());
            stmt.setInt(3, relatorioAnalise.getIdCliente());
            stmt.executeUpdate();
        }
    }
}
