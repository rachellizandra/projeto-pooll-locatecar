package classes.clientes;

import interfaces.ClienteRepository;

import java.util.List;

public class DadosCliente implements ClienteRepository {
    @Override
    public void buscar(List<Cliente> lista, String nomeBusca) {

    }

    @Override
    public <T extends Cliente> void cadastrar(T cliente) {

    }

    @Override
    public <T extends Cliente> void deletar(T cliente) {

    }

    @Override
    public <T extends Cliente> void atualizar(T cliente1, T cliente2) {

    }

    @Override
    public Cliente consultar(String numeroDocumento) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return null;
    }
}
