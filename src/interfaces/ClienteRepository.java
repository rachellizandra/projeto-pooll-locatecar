package interfaces;

import classes.clientes.Cliente;
import enuns.TipoDocumento;

import java.util.List;


public interface ClienteRepository {
    <T extends Cliente> void buscar(List<Cliente> lista, String nomeBusca);

    <T extends Cliente> void cadastrar(T cliente);

    <T extends Cliente> void deletar(T cliente);

    <T extends Cliente> void atualizar(T cliente1, T cliente2);

    Cliente consultar(TipoDocumento.tipoDocumento tipo, String numeroDocumento);

    List<Cliente> listarTodos();
}
