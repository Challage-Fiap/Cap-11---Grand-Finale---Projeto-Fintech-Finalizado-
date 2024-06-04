package Cliente;

public class Cliente {
    private int idCliente;
    private String nome;
    private String endereco;
    private String email;
    private String infoContato;

    // Getters and Setters

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setInfoContato(String infoContato) {
        this.infoContato = infoContato;
    }

    public String getInfoContato() {
        return infoContato;
    }

    // Override toString() for printing (optional)
    @Override
    public String toString() {
        return "Cliente{ " +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", infoContato='" + infoContato + '\'' +
                '}';
    }
}
