package aplicacaoBD;


public class Main {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();

//        pessoaDAO.criarTabelaPessoa();

        Pessoa pessoa1 = new Pessoa("Vitoria Ferreira", "79659882084", "(34) 99999-0000", "vitoria.ferreira@gmail.com", "1999-01-01");

//        pessoaDAO.inserirPessoa(pessoa1);

//        pessoaDAO.recuperarDadosTabela();

//        pessoaDAO.deletarDadosTabela();

        pessoaDAO.atualizardadosTabela();
    }
}
