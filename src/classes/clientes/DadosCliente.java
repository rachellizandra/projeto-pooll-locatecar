package classes.clientes;

import enuns.TipoDocumento;
import interfaces.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class DadosCliente implements ClienteRepository {

    public List<Cliente> listaDeClientes = new ArrayList<>();

    @Override
    public <T extends Cliente>  void buscar(List<Cliente> lista, String nomeBusca) {
        System.out.println("Resultado da busca por: " + nomeBusca);

        List<Cliente> resultadoNome = lista.stream()
                .filter(cliente -> nomeBusca.equalsIgnoreCase(cliente.getNome())).toList();
        List<Cliente> resultadoId = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getId())).toList();
        List<Cliente> resultadoNumeroDocumento = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getNumeroDocumento())).toList();

        if (!resultadoNome.isEmpty() || !resultadoId.isEmpty() || !resultadoNumeroDocumento.isEmpty()) {
            resultadoNome.forEach(cliente -> System.out.println("Nome: "+cliente.getNome().toLowerCase()));
            resultadoId.forEach(cliente -> System.out.println("Id: "+cliente.getId()));
            resultadoNumeroDocumento.forEach(cliente -> System.out.println("Número do documento: " + cliente.getNumeroDocumento()));
            System.out.println("--------------------");
        } else {
            System.out.println("Nenhum resultado encontrado para cliente " + nomeBusca + ".");
            System.out.println("--------------------");
        }
    }
    private boolean isClienteDisponivel(TipoDocumento.tipoDocumento tipo, String numeroDocumento) {
        return consultar(tipo, numeroDocumento) != null;
    }
    @Override
    public <T extends Cliente> void cadastrar(T cliente) {
        if (isClienteDisponivel(cliente.getTipoDocumento(), cliente.getNumeroDocumento())) {
            throw new IllegalArgumentException("Cliente " + cliente.getNome() + " com " + cliente.getTipoDocumento() + cliente.getNumeroDocumento() +
                    " já consta no banco de dados");
        }
        listaDeClientes.add(cliente);
        System.out.println("Novo cadastro de cliente realizado com sucesso!");
        System.out.println("--------------------");
    }

    @Override
    public <T extends Cliente> void deletar(T cliente) {
        if (cliente instanceof ClientePJ || cliente instanceof ClientePF) {
            if (isClienteDisponivel(cliente.getTipoDocumento(), cliente.getNumeroDocumento())) {
                listaDeClientes.remove(cliente);
                System.out.println("Cliente " + cliente.getNome() + " com " + cliente.getTipoDocumento() + " " + cliente.getNumeroDocumento() +
                        " foi deletado com sucesso!");
            }
        }
}

    @Override
    public <T extends Cliente> void atualizar(T cliente1, T cliente2) {
        if (cliente1 instanceof ClientePJ || cliente1 instanceof ClientePF) {
            if (!isClienteDisponivel(cliente1.getTipoDocumento(), cliente1.getNumeroDocumento())) {
                throw new IllegalArgumentException("Não foi possível atualizar este cliente, pois o mesmo ainda não foi cadastrado.");
            }
        }
        deletar(cliente1);
        cadastrar(cliente2);
        System.out.println("Cliente " + cliente2.getNome() + " atualizado com sucesso!");
    }

    @Override
    public Cliente consultar(TipoDocumento.tipoDocumento tipo, String numeroDocumento) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getTipoDocumento() == tipo) {
                if (cliente.getNumeroDocumento().equals(numeroDocumento)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        if (listaDeClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
        } else {
            System.out.println("Lista de Clientes: \n");
            for (Cliente cliente : listaDeClientes) {
                if (cliente instanceof ClientePJ) {
                    System.out.println("Cliente: " + cliente.getNome() +
                            "\nID: " + cliente.getId() +
                            "\nCNPJ: " + cliente.getNumeroDocumento() +
                            "\nTelefone: " + cliente.getTelefone() +
                            "\nEndereço: " + cliente.getEndereco());
                    System.out.println("--------------------");
                } else {
                    System.out.println("Cliente: " + cliente.getNome() +
                            "\nID: " + cliente.getId() +
                            "\nCPF: " + cliente.getNumeroDocumento() +
                            "\nTelefone: " + cliente.getTelefone() +
                            "\nEndereço: " + cliente.getEndereco());
                    System.out.println("--------------------");
                }
            }
        }
        return listaDeClientes;
    }
}
