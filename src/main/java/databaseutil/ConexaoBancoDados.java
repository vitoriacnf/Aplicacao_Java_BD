package databaseutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
    private static final String URL = "jdbc:mysql://localhost:3306/dados_pessoais";
    private static final String USUARIO = "developer";
    private static final String SENHA = "1234567";

    private static Connection conexao;

   static Connection criarConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados realizada com sucesso");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return null;
    }

    public static Connection obterConexao() {
        if (conexao == null) {
            criarConexao();
        }
        return conexao;
    }

    static void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
