package interfaces;

import classes.clientes.Cliente;
import classes.veiculos.Veiculo;
import enuns.TipoVeiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

public interface RepositoryAluguel {
    void alugar(Veiculo veiculo, Cliente cliente, LocalDateTime dataDeLocacao, Locale local);
    void listarVeiculosAlugados();
    BigDecimal calcularAluguel(Cliente cliente, TipoVeiculo.tipoVeiculo tipo,
                               LocalDateTime dataLocacao, LocalDateTime dataDevolucao);
}
