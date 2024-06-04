package HistoricoCretido;

public class HistCredito {
    private int idHistCredito;
    private String dadosRelacionados;
    private int idCliente;

    // Getters and Setters

    public int getIdHistCredito() {
        return idHistCredito;
    }

    public void setIdHistCredito(int idHistCredito) {
        this.idHistCredito = idHistCredito;
    }

    public String getDadosRelacionados() {
        return dadosRelacionados;
    }

    public void setDadosRelacionados(String dadosRelacionados) {
        this.dadosRelacionados = dadosRelacionados;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Optional: Override toString() for printing
    @Override
    public String toString() {
        return "HistCredito{" +
                "idHistCredito=" + idHistCredito +
                ", dadosRelacionados='" + dadosRelacionados + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
