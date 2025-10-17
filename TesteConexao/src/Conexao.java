import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


    private static final String URL = "jdbc:mysql://18.230.65.88:4582/pastelaria";
    private static final String USUARIO = "pastelaria";
    private static final String SENHA = "remote4P$";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }// Caso de Merda no DriverJDBC
        catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não encontrado!", e);
        }// Caso de Merda na Conexão
        catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}