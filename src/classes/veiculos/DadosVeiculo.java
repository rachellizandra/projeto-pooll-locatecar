package classes.veiculos;

import interfaces.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;

public class DadosVeiculo implements VeiculoRepository {
    public List<Veiculo> listaDeVeiculos = new ArrayList<>();
    @Override
    public void buscar(List<Veiculo> lista, String nomeBusca) {
        System.out.println("Resultado da busca por: "+nomeBusca);
        List<Veiculo> resultadoVeiculos = lista.stream()
                .filter(veiculo -> nomeBusca.equals(veiculo.getModelo())).toList();

        if(!resultadoVeiculos.isEmpty()) {
            resultadoVeiculos.forEach(veiculo -> System.out.println("Placa: "+veiculo.getPlaca()));
            System.out.println("--------------------");
        } else {
            System.out.println("Nenhum resultado encontrado para o veículo "+nomeBusca+".");
            System.out.println("--------------------");
        }

    }

    private boolean isPlacaDisponivel(String placa) {
        return consultar(placa) != null;
    }
    @Override
    public <T extends Veiculo> void cadastrar(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veiculo de placa " + veiculo.getPlaca() +
                    " já consta no banco de dados");
        }
        listaDeVeiculos.add(veiculo);
    }

    @Override
    public <T extends Veiculo> void deletar(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            listaDeVeiculos.remove(veiculo);
            System.out.println("Veiculo placa " + veiculo.getPlaca() + " foi deletado com sucesso.");
        }
    }

    @Override
    public <T extends Veiculo> void atualizar(T veiculo1, T veiculo2) {
        if (!isPlacaDisponivel(veiculo1.getPlaca())) {
            throw new IllegalArgumentException("Não foi possível atualizar veículo " +
                    "pois o mesmo ainda não foi cadastrado!");
        }
        deletar(veiculo1);
        cadastrar(veiculo2);
    }

    @Override
    public Veiculo consultar(String placa) {
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        if (listaDeVeiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
        } else {
            System.out.println("Lista de Veículos: \n");
            for (Veiculo veiculo : listaDeVeiculos) {
                System.out.println("Tipo: " + veiculo.getClass().getSimpleName() +
                        "\nCategoria: " + veiculo.getTipo() +
                        "\nModelo: " + veiculo.getModelo() +
                        "\nMarca: " + veiculo.getMarca() +
                        "\nAno: " + veiculo.getAno() +
                        "\nPlaca: " + veiculo.getPlaca() +
                        "\nKms Rodados: " + veiculo.getQuilometragem());
                System.out.println("--------------------");
            }
        }
        return listaDeVeiculos;
    }
}
