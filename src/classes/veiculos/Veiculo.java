package classes.veiculos;

import enuns.TipoVeiculo;

public class Veiculo {
    private TipoVeiculo.tipoVeiculo tipo;
    private String modelo;
    private String marca;
    private String ano;
    private String placa;
    private Double quilometragem;

    private Boolean disponivel;


    public Veiculo(String modelo, String marca, String ano, String placa, Double quilometragem) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.disponivel = true;
    }

    public String getModelo() {
        return this.modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getAno() {
        return this.ano;
    }
    public Double getQuilometragem() {
        return this.quilometragem;
    }
    public String getPlaca() {
        return this.placa;
    }

    public TipoVeiculo.tipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo.tipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
    @Override
    public String toString() {
        return "Categoria: "+this.tipo+
                "\nModelo: "+this.modelo+
                "\nMarca: "+this.marca+
                "\nAno: "+this.ano+
                "\nPlaca: "+this.placa+
                "\nQuilometragem: "+this.quilometragem;
    }
}
