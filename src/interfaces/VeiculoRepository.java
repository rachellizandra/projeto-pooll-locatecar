package interfaces;

import classes.veiculos.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    void buscar(List<Veiculo> lista, String nomeBusca);

    <T extends Veiculo> void cadastrar(T veiculo);

    <T extends Veiculo> void deletar(T veiculo);

    <T extends Veiculo> void atualizar(T veiculo1, T veiculo2);

    Veiculo consultar(String placa);

    List<Veiculo> listarTodos();
}
