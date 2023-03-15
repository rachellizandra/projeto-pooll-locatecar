package classes.locacao;

import classes.clientes.Cliente;
import classes.clientes.ClientePF;
import classes.clientes.ClientePJ;
import classes.veiculos.Veiculo;
import enuns.TipoVeiculo;
import interfaces.RepositoryAluguel;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Set;

import static enuns.TipoVeiculo.tipoVeiculo.*;

public class Aluguel extends Locacao implements RepositoryAluguel {

    private static final BigDecimal BASE_CALC_VEIC_PEQUENO = BigDecimal.valueOf(100);
    private static final BigDecimal BASE_CALC_VEIC_MEDIO = BigDecimal.valueOf(150);
    private static final BigDecimal BASE_CALC_VEIC_SUV = BigDecimal.valueOf(200);

    Validacao validacaoData = new Validacao();
    @Override
    public void alugar(Veiculo veiculo, Cliente cliente, LocalDateTime dataLocacao, Locale local) {
        if (locadora.containsKey(veiculo) && !veiculo.getDisponivel()) {
            System.out.println("Este veiculo "+veiculo.getModelo()+" não está disponivel para locação.");
            System.out.println("--------------------");
        } else {
            locadora.put(veiculo, cliente);
            setDataLocacao(dataLocacao);
            veiculo.setDisponivel(false);
            System.out.println("Veículo "+veiculo.getModelo()+
                    " alugado com sucesso por cliente ID: " + cliente.getId());
            System.out.println("--------------------");
        }
    }

    @Override
    public void listarVeiculosAlugados() {
        Set<Veiculo> alugados = locadora.keySet();
        System.out.println("Veiculos alugados: ");
        if (alugados.isEmpty()) {
            System.out.println("Não há veículos alugados.");
        } else {
            for (Veiculo alugado : alugados) {
                if (alugado != null)
                    System.out.println(alugado+ "\nData: "+ locadora.get(alugado));
                System.out.println("--------------------");
            }
        }
    }

    private BigDecimal calcularDesconto(Cliente cliente, long dias) {

        if (cliente instanceof ClientePF && dias > 5) {
            return BigDecimal.valueOf(0.05);
        }
        if (cliente instanceof ClientePJ && dias > 3) {
            return BigDecimal.valueOf(0.1);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calcularAluguel(Cliente cliente, TipoVeiculo.tipoVeiculo tipo,
                                       LocalDateTime dataLocacao, LocalDateTime dataDevolucao) {
        validacaoData.validarData(dataDevolucao, dataLocacao);

        long dias = Duration.between(dataLocacao, dataDevolucao).toDays() + 1;

        if (dias <= 1) { dias = 1;}

        BigDecimal desconto = calcularDesconto(cliente, dias);

        BigDecimal valorSemDesconto = BigDecimal.ZERO;

        if (tipo.equals(PEQUENO)) {
            valorSemDesconto = BigDecimal.valueOf(dias).multiply(BASE_CALC_VEIC_PEQUENO);
        } else if (tipo.equals(MEDIO)) {
            valorSemDesconto = BigDecimal.valueOf(dias).multiply(BASE_CALC_VEIC_MEDIO);
        } else if (tipo.equals(SUV)) {
            valorSemDesconto = BigDecimal.valueOf(dias).multiply(BASE_CALC_VEIC_SUV);
        }
        return valorSemDesconto.subtract(valorSemDesconto.multiply(desconto));
    }
}
