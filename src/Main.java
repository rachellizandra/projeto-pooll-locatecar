import classes.Locacao;
import classes.clientes.ClientePF;
import classes.clientes.ClientePJ;
import classes.clientes.DadosCliente;
import enuns.TipoDocumento;

public class Main {
    public static void main(String[] args) {

        DadosCliente bancoClientes = new DadosCliente();
        Locacao locacao = new Locacao();

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

    }
}