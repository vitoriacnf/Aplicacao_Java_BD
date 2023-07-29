package aplicacaoBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    public void criarTabelaPessoa() {
        String sql = "CREATE TABLE pessoa (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "nome VARCHAR(100)," +
                "cpf VARCHAR(100)," +
                "telefone VARCHAR(15)," +
                "email VARCHAR(200)," +
                "data_nascimento DATE," +
                "PRIMARY KEY (id)" +
                ");";

        try (Connection connection = ConexaoBancoDados.obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            System.out.println("Tabela pessoa criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela pessoa: " + e.getMessage());
        }
    }


    public void inserirPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, cpf, telefone, email, data_nascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoBancoDados.obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getTelefone());
            preparedStatement.setString(4, pessoa.getEmail());
            preparedStatement.setString(5, pessoa.getDataNascimento());

            preparedStatement.executeUpdate();
            System.out.println("Pessoa inserida na tabela pessoa com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }

    public void recuperarDadosTabela() {
        ResultSet rs = null;
        String sql = "SELECT * FROM pessoa";

        try (Connection connection = ConexaoBancoDados.obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao recuparar os dados solicitados" + e.getMessage());
        }
    }

    public void deletarDadosTabela(){
        String sql = "DELETE FROM pessoa " +
                "WHERE " +
                "id = ?";

        try(Connection connection = ConexaoBancoDados.obterConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizardadosTabela(){
        String sql = "UPDATE pessoa " +
                "SET telefone = ? " +
                "WHERE " +
                "(id = ?)";

        try(Connection connection = ConexaoBancoDados.obterConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, "(34) 99991-0001");
            preparedStatement.setInt(2, 2);
            int linhasAfetadas = preparedStatement.executeUpdate();


            System.out.println("Dados da tabela atualizados com sucesso! Quantidade de linhas afetadas: " + linhasAfetadas);

        }catch (SQLException e){
            System.out.println("Erro ao atualizar dados da tabela " + e.getMessage());
        }
    }
}
