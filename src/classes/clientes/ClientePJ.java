package classes.clientes;

import enuns.TipoDocumento;

public class ClientePJ extends Cliente {

    public ClientePJ(String nome, String id, TipoDocumento.tipoDocumento tipoDocumento, String numeroDocumento, String telefone, String endereco) {
        super(nome, id, numeroDocumento, telefone, endereco);
        this.setTipoDocumento(tipoDocumento);
    }

}
