package classes.clientes;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String id, String cnpj) {
        super(nome, id);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
