package Trasacao;

import java.sql.Date;
import java.sql.SQLException;

public class TrasacaoDAOTest {
    public static void testGetAllTransacoes() {
        TrasacaoDAO trasacaoDAO = new TrasacaoDAO();
        try {
            System.out.println("Teste de getAllTransacoes:");
            for (Transacao transacao : trasacaoDAO.getAllTransacoes()) {
                System.out.println(transacao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter transações: " + e.getMessage());
        }
    }

    public static void testInsertTransacao() {
        TrasacaoDAO trasacaoDAO = new TrasacaoDAO();
        try {
            System.out.println("Teste de insertTransacao:");
            Transacao transacao = new Transacao();
            transacao.setIdTransacao(1); // Defina um ID adequado para teste
            transacao.setData(new Date(System.currentTimeMillis())); // Data atual
            transacao.setValor(100.0); // Defina um valor adequado para teste
            transacao.setContaNrConta("12345"); // Defina um número de conta adequado para teste

            trasacaoDAO.insertTransacao(transacao);
            System.out.println("Transação inserida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir transação: " + e.getMessage());
        }
    }
}
