package aluguelcarro.persistencia.jdbc;

import aluguelcarro.models.Cliente;
import aluguelcarro.persistencia.dao.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public class JDBCCLienteDAO extends AbstractJDBC implements ClienteDAO {

    protected static final String COL_ID = "id";
    protected static final String COL_NOME = "nome";
    protected static final String COL_CPF = "cpf";
    protected static final String COL_TELEFONE = "telefone";

    public JDBCCLienteDAO() {
        super();
    }  
    
    @Override
    public void save(Cliente cliente) {

        String sql = "INSERT INTO " + TB_CLIENTE + "(" + COL_NOME + ", " + COL_CPF + ", " + COL_TELEFONE + ") VALUES (?, ?, ?)";

        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(Cliente cliente) {
        String sql = "DELETE FROM  " + TB_CLIENTE + " WHERE cliente.id = ?";

        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "";
        sql = "SELECT " + 
                TB_CLIENTE + "." + COL_ID + "," + 
                TB_CLIENTE + "." + COL_NOME + "," + 
                TB_CLIENTE + "." + COL_CPF + "," + 
                TB_CLIENTE + "." + COL_TELEFONE + 
            " FROM " + TB_CLIENTE;
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(COL_ID));
                cliente.setNome(rs.getString(COL_NOME));
                cliente.setCpf(rs.getString(COL_CPF));
                cliente.setTelefone(rs.getString(COL_TELEFONE));
                clientes.add(cliente);
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return clientes;

    }

    @Override
    public Cliente findById(int id) {
        Cliente cliente = new Cliente();
        String sql = "";
        sql = "SELECT " + TB_CLIENTE + "." + COL_ID + "," + TB_CLIENTE + "." + COL_NOME + "," + TB_CLIENTE + "." + COL_CPF + "," + TB_CLIENTE + "." + COL_TELEFONE + " FROM " + TB_CLIENTE + " WHERE cliente.id = ?";
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt(COL_ID));
                cliente.setNome(rs.getString(COL_NOME));
                cliente.setCpf(rs.getString(COL_CPF));
                cliente.setTelefone(rs.getString(COL_TELEFONE));
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

    @Override
    public Cliente findByName(String name) {
        Cliente cliente = new Cliente();
        String sql = "";
        sql = "SELECT " + TB_CLIENTE + "." + COL_ID + "," + TB_CLIENTE + "." + COL_NOME + "," + TB_CLIENTE + "." + COL_CPF + "," + TB_CLIENTE + "." + COL_TELEFONE + " FROM " + TB_CLIENTE + " WHERE cliente.nome = ?";
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente.setId(rs.getInt(COL_ID));
                cliente.setNome(rs.getString(COL_NOME));
                cliente.setCpf(rs.getString(COL_CPF));
                cliente.setTelefone(rs.getString(COL_TELEFONE));
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

}
