package Contas;
import java.sql.SQLException;

public class ContaDAOTest {
        public static void testGetAllContas() {
        ContaDAO contaDAO = new ContaDAO();
        try {
            System.out.println("Teste de getAllContas:");
            for (Conta conta : contaDAO.getAllContas()) {
                System.out.println(conta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter contas: " + e.getMessage());
        }
    }

    public static void testInsertConta() {
        ContaDAO contaDAO = new ContaDAO();
        try {
            System.out.println("Teste de insertConta:");
            Conta conta = new Conta();
            conta.setNrConta("12345");
            conta.setTpConta("Corrente");
            conta.setSaldo(1000.0);
            conta.setIdCliente(1);

            contaDAO.insertConta(conta);
            System.out.println("Conta inserida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta: " + e.getMessage());
        }
    }
}
