package aplicacaoBD;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    PessoaDAO pessoaDAO = new PessoaDAO();
    Pessoa pessoa1 = new Pessoa("Vitoria Ferreira", "79659882084", "(34) 99999-0000", "vitoria.ferreira@gmail.com", "1999-01-01");

    public void mostrarMenu() {
        int opcao;

        System.out.println("1. Criar tabela" +
                "\n2. Inserir pessoa" +
                "\n3. Recuperar dados da tabela" +
                "\n4. Deletar dados da tabela" +
                "\n5. Atualizar dados");

        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                pessoaDAO.criarTabelaPessoa();
                break;
            case 2:
                pessoaDAO.inserirPessoa(pessoa1);
                break;
            case 3:
                pessoaDAO.recuperarDadosTabela();
                break;
            case 4:
                pessoaDAO.deletarDadosTabela();
                break;
            case 5:
                pessoaDAO.atualizardadosTabela();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}
