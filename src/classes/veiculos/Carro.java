package classes.veiculos;

import enuns.TipoVeiculo;

public class Carro extends Veiculo {
    public Carro(TipoVeiculo.tipoVeiculo tipo, String modelo, String marca, String ano, String placa, Double quilometragem) {
        super(modelo, marca, ano, placa, quilometragem);
        this.setTipo(tipo);
    }
}
