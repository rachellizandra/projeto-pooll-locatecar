package interfaces;

import classes.clientes.Cliente;
import classes.veiculos.Veiculo;

import java.time.LocalDateTime;
import java.util.Locale;

public interface RepositoryDevolucao {
    void devolver(Veiculo veiculo, Cliente cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, Locale local);
}
