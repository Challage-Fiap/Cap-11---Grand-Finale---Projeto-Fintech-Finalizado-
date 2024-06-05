package RelatorioDeAnalises;

import java.sql.SQLException;

public class RelatoriosAnalisesDAOTest {
    public static void testGetAllRelatoriosAnalises() {
        RelatoriosAnalisesDAO relatoriosAnalisesDAO = new RelatoriosAnalisesDAO();
        try {
            System.out.println("Teste de getAllRelatoriosAnalises:");
            for (RelatoriosAnalises relatorioAnalise : relatoriosAnalisesDAO.getAllRelatoriosAnalises()) {
                System.out.println(relatorioAnalise);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter relatórios de análises: " + e.getMessage());
        }
    }

    public static void testInsertRelatorioAnalise() {
        RelatoriosAnalisesDAO relatoriosAnalisesDAO = new RelatoriosAnalisesDAO();
        try {
            System.out.println("Teste de insertRelatorioAnalise:");
            RelatoriosAnalises relatorioAnalise = new RelatoriosAnalises();
            relatorioAnalise.setIdRelatorioAnalise(1); // Defina um ID adequado para teste
            relatorioAnalise.setDadosAnalisesRelatorios("Dados de análise de relatório de teste");
            relatorioAnalise.setIdCliente(1); // Defina um ID de cliente válido para teste

            relatoriosAnalisesDAO.insertRelatorioAnalise(relatorioAnalise);
            System.out.println("Relatório de análise inserido com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir relatório de análise: " + e.getMessage());
        }
    }
}
