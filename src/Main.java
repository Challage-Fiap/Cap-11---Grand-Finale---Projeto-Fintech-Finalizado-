import java.sql.*;
import Contas.ContaDAO;
import Contas.Conta;
import Cliente.ClienteDAO;
import Cliente.Cliente;
import HistoricoCretido.HistCreditoDAO;
import HistoricoCretido.HistCredito;
import RelatorioDeAnalises.RelatoriosAnalisesDAO;
import RelatorioDeAnalises.RelatoriosAnalises;
import Trasacao.TrasacaoDAO;
import Trasacao.Transacao;

public class Main {
    public static void main(String[] args) throws SQLException {
        // colocar os testes aqui (so chamar as funções e importar)


        ContaDAO contaDAO = new ContaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        HistCreditoDAO histCreditoDAO = new HistCreditoDAO();
        RelatoriosAnalisesDAO relatoriosAnalisesDAO = new RelatoriosAnalisesDAO();
        TrasacaoDAO trasacaoDAO = new TrasacaoDAO();

        System.out.println("Get all reports Contas:");
        try {
            for (Conta conta : contaDAO.getAllContas()) {
                System.out.println(conta);
            }
        } catch (SQLException e) {
            System.err.println("Error getting reports: 1" + e.getMessage());
        }

        System.out.println("Get all reports Cliente:");
        try {
            for (Cliente cliente : clienteDAO.getAllClientes()) {
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error getting reports: 2" + e.getMessage());
        }

        System.out.println("Get all reports histCreditoDAO:");
        try {
            for (HistCredito histCredito : histCreditoDAO.getAllHistCredito()) {
                System.out.println(histCredito);
            }
        } catch (SQLException e) {
            System.err.println("Error getting reports: 3" + e.getMessage());
        }

        System.out.println("Get all reports relatoriosAnalises:");
        try {
            for (RelatoriosAnalises relatoriosAnalises : relatoriosAnalisesDAO.getAllRelatoriosAnalises()) {
                System.out.println(relatoriosAnalises);
            }
        } catch (SQLException e) {
            System.err.println("Error getting reports: 4" + e.getMessage());
        }

        System.out.println("Get all reports Transacao:");
        try {
            for (Transacao transacao : trasacaoDAO.getAllTransacoes()) {
                System.out.println(transacao);
            }
        } catch (SQLException e) {
            System.err.println("Error getting reports: 4" + e.getMessage());
        }
    }
}
