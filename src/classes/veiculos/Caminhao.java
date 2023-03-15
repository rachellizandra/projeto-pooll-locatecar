package classes.veiculos;

import enuns.TipoVeiculo;

public class Caminhao extends Veiculo {
    public Caminhao(TipoVeiculo.tipoVeiculo tipo, String modelo, String marca, String ano, String placa, Double quilometragem) {
        super(modelo, marca, ano, placa, quilometragem);

        if(TipoVeiculo.tipoVeiculo.SUV == tipo) {
            throw new IllegalArgumentException("Tipo de veículo não suportado");
        }
        this.setTipo(tipo);
    }
}
