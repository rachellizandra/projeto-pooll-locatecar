package classes.clientes;

public class ClientePF extends Cliente{

    private String cpf;

    public ClientePF(String nome, String id, String cpf) {
        super(nome, id);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
