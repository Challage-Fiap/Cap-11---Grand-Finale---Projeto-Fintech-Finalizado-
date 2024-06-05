package HistoricoCretido;
import java.sql.SQLException;

public class HistCreditoDAOTest {
    public static void testGetAllHistCredito() {
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
        try {
            System.out.println("Teste de getAllHistCredito:");
            for (HistCredito histCredito : histCreditoDAO.getAllHistCredito()) {
                System.out.println(histCredito);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter histórico de crédito: " + e.getMessage());
        }
    }

    public static void testInsertHistCredito() {
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
        try {
            System.out.println("Teste de insertHistCredito:");
            HistCredito histCredito = new HistCredito();
            histCredito.setIdHistCredito(1); // Defina um ID adequado para teste
            histCredito.setDadosRelacionados("Dados relacionados de teste");
            histCredito.setIdCliente(1); // Defina um ID de cliente válido para teste

            histCreditoDAO.insertHistCredito(histCredito);
            System.out.println("Histórico de crédito inserido com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir histórico de crédito: " + e.getMessage());
        }
    }
}
