package aluguelcarro.persistencia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection conexao;
    private static ConnectionManager instancia;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstancia() {
        if (instancia == null) {
            instancia = new ConnectionManager();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fecharConexao() throws SQLException {
        try {
            conexao.close();
        } catch (SQLException ex) {
            throw new SQLException("Falha ao fechar conexão");
        }
    }

    public Connection abrirConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluguel", "root", "");
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
