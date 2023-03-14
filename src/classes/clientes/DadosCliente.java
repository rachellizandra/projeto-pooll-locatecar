package classes.clientes;

import interfaces.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class DadosCliente implements ClienteRepository {
    @Override
    public <T extends Cliente>  void buscar(List<Cliente> lista, String nomeBusca) {
        System.out.println("Resultado da busca por: " + nomeBusca);

        List<Cliente> resultadoNome = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getName())).toList();
        List<Cliente> resultadoId = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getId())).toList();

        if (!resultadoNome.isEmpty() || !resultadoId.isEmpty()) {
            resultadoNome.forEach(cliente -> System.out.println("CPF: "+cliente.getName()));
            resultadoId.forEach(cliente -> System.out.println("CNPJ: "+cliente.getId()));
            System.out.println("--------------------");
        } else {
            System.out.println("Nenhum resultado encontrado para cliente "+nomeBusca+".");
            System.out.println("--------------------");
        }

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
