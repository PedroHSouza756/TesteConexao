import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tentando conectar ao banco...");

        try (Connection conn = Conexao.getConnection()) {
            System.out.println("Conexão bem-sucedida!");

            // Insert de Pastel
            try (Statement stmt = conn.createStatement()) {
                int linhas = stmt.executeUpdate(
                        "INSERT INTO pasteis (ID_pastel,ID_produto ,sabor, preco) VALUES " +
                                "(20,1, 'Feijoada',30.00)"
                );
                //Se deu certo
                System.out.println( linhas + " linha(s) inserida(s) na tabela pasteis.");
            } catch (SQLException e) {
                //Se deu merda
                System.out.println("Erro ao inserir pastel: " + e.getMessage());
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SHOW TABLES")) {

                System.out.println("\n Tabelas encontradas no banco:");
                boolean encontrou = false;
                while (rs.next()) {
                    System.out.println(" - " + rs.getString(1));
                    encontrou = true;
                }
                if (!encontrou) {
                    System.out.println("Nenhuma tabela encontrada.");
                }

            } catch (SQLException e) {
                System.out.println("Erro ao listar tabelas: " + e.getMessage());
            }

        }

        catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
