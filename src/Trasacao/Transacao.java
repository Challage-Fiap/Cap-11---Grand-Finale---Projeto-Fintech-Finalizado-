package Trasacao;
import java.sql.Date;


public class Transacao {
    private int idTransacao;
    private Date data;
    private double valor;
    private String contaNrConta;


    public Transacao() {}

    public Transacao(int idTransacao, Date data, double valor, String contaNrConta) {
        this.idTransacao = idTransacao;
        this.data = data;
        this.valor = valor;
        this.contaNrConta = contaNrConta;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getContaNrConta() {
        return contaNrConta;
    }

    public void setContaNrConta(String contaNrConta) {
        this.contaNrConta = contaNrConta;
    }

    // Optional: Override toString() for printing
    @Override
    public String toString() {
        return "Transacao{" +
                "idTransacao=" + idTransacao +
                ", data=" + data +
                ", valor=" + valor +
                ", contaNrConta='" + contaNrConta + '\'' +
                '}';
    }
}
