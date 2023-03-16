package classes.clientes;

import enuns.TipoDocumento;

public abstract class Cliente {
    private String nome;
    private String id;
    private TipoDocumento.tipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String id, String numeroDocumento, String telefone, String endereco) {
        this.nome = nome;
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public TipoDocumento.tipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento.tipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
