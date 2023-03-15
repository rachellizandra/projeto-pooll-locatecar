package classes.clientes;

import enuns.TipoDocumento;

public class ClientePF extends Cliente{

    public ClientePF(String nome, String id, TipoDocumento.tipoDocumento tipoDocumento, String numeroDocumento, String telefone, String endereco) {
        super(nome, id, numeroDocumento, telefone, endereco);
        this.setTipoDocumento(tipoDocumento);
    }
}
