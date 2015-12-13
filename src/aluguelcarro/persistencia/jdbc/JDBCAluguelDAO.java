package aluguelcarro.persistencia.jdbc;

import aluguelcarro.models.Aluguel;
import aluguelcarro.models.Carro;
import aluguelcarro.models.Cliente;
import aluguelcarro.persistencia.dao.AluguelDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos
 */
public class JDBCAluguelDAO extends AbstractJDBC implements AluguelDAO{
    
    protected static final String COL_CLIENTE_ID = "cliente_id";
    protected static final String COL_CARRO_ID = "carro_id";
    protected static final String COL_DT_INICIO = "data_inicio";
    protected static final String COL_DT_FIM = "data_fim";
    
    @Override
    public void save(Aluguel aluguel) {
        String sql = "INSERT INTO " + TB_ALUGUEL + "(" + COL_CLIENTE_ID + ", " + COL_CARRO_ID + ", " + COL_DT_INICIO + ", " + COL_DT_FIM + ") VALUES (?, ?, ?, ?)";
    
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, aluguel.getCliente().getId());
            stmt.setInt(2, aluguel.getCarro().getId());
            stmt.setString(3, aluguel.getDtInicio());
            stmt.setString(4, aluguel.getDtFim());
            
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Aluguel> findAll() {
        ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
        String sql = "";
        sql = "SELECT " + 
                TB_ALUGUEL + "." + COL_CLIENTE_ID + "," + 
                TB_ALUGUEL + "." + COL_CARRO_ID + "," + 
                TB_ALUGUEL + "." + COL_DT_INICIO + "," + 
                TB_ALUGUEL + "." + COL_DT_FIM +
             " FROM " + TB_CARRO;
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluguel aluguel = new Aluguel();
                
                Cliente cliente = new Cliente();
                Carro carro = new Carro();
                JDBCCLienteDAO jdbcCliente = new JDBCCLienteDAO();
                JDBCCarroDAO jdbcCarro = new JDBCCarroDAO();
                cliente = jdbcCliente.findById(rs.getInt(COL_CLIENTE_ID));
                carro = jdbcCarro.findById(rs.getInt(COL_CARRO_ID));
                
                aluguel.setCarro(carro);
                aluguel.setCliente(cliente);
                aluguel.setDtInicio(rs.getString(COL_DT_INICIO));
                aluguel.setDtFim(rs.getString(COL_DT_FIM));
                alugueis.add(aluguel);
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return alugueis;
    }

    @Override
    public Aluguel findByCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
