package classes.locacao;

import classes.clientes.Cliente;
import classes.veiculos.Veiculo;
import interfaces.RepositoryDevolucao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

public class Devolucao extends Locacao implements RepositoryDevolucao {

    Validacao validacaoData = new Validacao();

    public Devolucao(HashMap<Veiculo, Cliente> locadora) {
        super(locadora);
    }

    @Override
    public void devolver(Veiculo veiculo, Cliente cliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, Locale local) {
        validacaoData.validarData(dataDevolucao, dataLocacao);

        if(locadora.containsKey(veiculo)) {
            locadora.remove(veiculo);
            setDataDevolucao(dataDevolucao);
            System.out.println("Veículo devolvido com sucesso!");
        } else {
            System.out.println("Esse veículo "+veiculo.getModelo()+" não foi alugado.");
            System.out.println("--------------------");
        }
    }
}
