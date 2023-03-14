package interfaces;

import classes.clientes.Cliente;

import java.util.List;


public interface ClienteRepository {
    void buscar(List<Cliente> lista, String nomeBusca);

    <T extends Cliente> void cadastrar(T cliente);

    <T extends Cliente> void deletar(T cliente);

    <T extends Cliente> void atualizar(T cliente1, T cliente2);

    Cliente consultar(String numeroDocumento);

    List<Cliente> listarTodos();
}
