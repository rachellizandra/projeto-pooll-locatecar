import classes.clientes.Cliente;
import classes.locacao.Aluguel;
import classes.locacao.Devolucao;
import classes.locacao.Locacao;
import classes.clientes.ClientePF;
import classes.clientes.ClientePJ;
import classes.clientes.DadosCliente;
import classes.veiculos.*;
import enuns.TipoDocumento;
import enuns.TipoVeiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        DadosCliente bancoClientes = new DadosCliente();
        DadosVeiculo bancoVeiculos = new DadosVeiculo();

        HashMap<Veiculo, Cliente> locadora = new HashMap<>();
        Aluguel locacao = new Aluguel(locadora);
        Devolucao devolucao = new Devolucao(locadora);

        //CADASTRAR CLIENTE
        ClientePF rachel = new ClientePF("Rachel", "25", TipoDocumento.tipoDocumento.CPF, "56985748575", "259595", "RUA CANADÁ, 258");
        ClientePF pedro = new ClientePF("pedro", "26", TipoDocumento.tipoDocumento.CPF, "33385748575", "259595", "RUA CANADÁ, 778");
        ClientePJ fabrica = new ClientePJ("Fabrica de brinquedos", "33", TipoDocumento.tipoDocumento.CNPJ, "98596595989", "555649", "rua major, 22");
        ClientePJ loja = new ClientePJ("takita", "37", TipoDocumento.tipoDocumento.CNPJ, "11596595989", "555649", "rua navalha, 72");
        bancoClientes.cadastrar(pedro);
        bancoClientes.cadastrar(rachel);
        bancoClientes.cadastrar(fabrica);
        bancoClientes.cadastrar(loja);
        bancoClientes.listarTodos();

        //BUSCAR CLIENTE PELO NOME
        bancoClientes.buscar(bancoClientes.listaDeClientes,"rachel");
        bancoClientes.buscar(bancoClientes.listaDeClientes,"fabrica de brinquedos");

        //BUSCANDO CLIENTE QUE NAO EXISTE
        bancoClientes.buscar(bancoClientes.listaDeClientes,"Serginho Mallandro");

        //ALTERAR CLIENTE PF
        ClientePF rachel2 = new ClientePF("rachel", "37", TipoDocumento.tipoDocumento.CPF, "222", "259595", "RUA CANADÁ, 258");
        bancoClientes.atualizar(pedro,rachel2);

        //ALTERAR CLIENTE PJ
        ClientePJ padaria = new ClientePJ("Fabrica de pães", "35", TipoDocumento.tipoDocumento.CNPJ, "55596595989", "555649", "rua major, 22");
        bancoClientes.atualizar(fabrica,padaria);
        bancoClientes.listarTodos();

        //CADASTRANDO VEICULOS
        Moto suzuki = new Moto(TipoVeiculo.tipoVeiculo.MEDIO,"Ninja","Suzuki","2003",
                "SUZ-1202",25000.00);
        Caminhao scania = new Caminhao(TipoVeiculo.tipoVeiculo.MEDIO,"Truck","Scania","2005",
                "SCA-5030",69999.99);
        Carro palio = new Carro(TipoVeiculo.tipoVeiculo.PEQUENO,"Palio","Fiat","1998",
                "PAL-3030",25070.35);
        Carro blazer = new Carro(TipoVeiculo.tipoVeiculo.SUV,"Blazer","Chevrolet","1995",
                "BLA-1000",100000.00);
        bancoVeiculos.cadastrar(suzuki);
        bancoVeiculos.cadastrar(scania);
        bancoVeiculos.cadastrar(palio);
        bancoVeiculos.listarTodos();

        //ALTERANDO VEICULO JÁ CADASTRADO
        Carro fiesta = new Carro(TipoVeiculo.tipoVeiculo.PEQUENO,"Fiesta","Ford","2006",
                "FIE-3303",50060.20);
        Carro fiesta2 = new Carro(TipoVeiculo.tipoVeiculo.PEQUENO,"Fiesta","Ford","2010",
                "GKW-3411",55030.20);

        bancoVeiculos.atualizar(palio,fiesta);
        bancoVeiculos.listarTodos();

        //BUSCAR VEICULO (EXEMPLO COM 2 VEICULOS IGUAIS COM PLACAS DIFERENTES)
        bancoVeiculos.cadastrar(fiesta2);
        bancoVeiculos.buscar(bancoVeiculos.listaDeVeiculos,"Fiesta");

        //BUSCANDO VEICULO QUE NAO EXISTE
        bancoVeiculos.buscar(bancoVeiculos.listaDeVeiculos,"Ferrari");

        //DEVOLVER VEICULO PF
//        locacao.alugar(fiesta,rachel, LocalDateTime.of(2023,1,2,12,30), Locale.JAPAN);
//        //DADOS DO ALUGUEL: PESSOA FISICA / 10 DIAS / VEICULO PEQUENO -> 100 X 10 - (100 X 10 x 0.05) = 950
//        locacao.devolver(fiesta,rachel,LocalDateTime.of(2023,1,12,12,30),Locale.JAPAN);
//
//        //DEVOLVER VEICULO PJ
//        locacao.alugar(blazer,padaria,LocalDateTime.of(2023,1,1,15,0),Locale.ITALY);
//        //DADOS DO ALUGUEL: PESSOA JURIDICA / 5 DIAS / VEICULO SUV = 200 * 5 - (200 * 5 * 0,1) = 900
//        locacao.devolver(blazer,padaria,LocalDateTime.of(2023,1,6,15,0),Locale.ITALY);
//        //TENTANDO DEVOLVER VEICULO NÃO ALUGADO
//        locacao.devolver(suzuki,rachel,LocalDateTime.of(2023,1,12,12,30),Locale.JAPAN);

        //VERIFICAR PORQUE NA DATA ESTÁ SAINDO O ENDEREÇO DE MEMÓRIA
        locacao.alugar(scania, pedro, LocalDateTime.of(2023,1,1,15,0), Locale.ITALY);
        locacao.alugar(fiesta, rachel, LocalDateTime.of(2023,2,1,15,0), Locale.CANADA);
        locacao.listarVeiculosAlugados();
        BigDecimal valorAluguel = locacao.calcularAluguel(pedro, TipoVeiculo.tipoVeiculo.MEDIO, LocalDateTime.of(2023,1,1,15,0), LocalDateTime.of(2023,1,2,15,0));
        System.out.println("Valor do aluguel: " + valorAluguel);
        devolucao.devolver(fiesta, rachel, LocalDateTime.of(2023,2,1,15,0), LocalDateTime.of(2023,3,1,15,0), Locale.CANADA);
        locacao.listarVeiculosAlugados();
    }
}