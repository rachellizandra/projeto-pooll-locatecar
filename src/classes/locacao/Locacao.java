package classes.locacao;

import classes.clientes.Cliente;
import classes.veiculos.Veiculo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

public class Locacao {

    HashMap<Veiculo, Cliente> locadora;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private Locale local;

    public Locacao() {
        locadora = new HashMap<>();
    }

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Locale getLocal() {
        return local;
    }

    public void setLocal(Locale local) {
        this.local = local;
    }
}
