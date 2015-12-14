package aluguelcarro.persistencia.jdbc;

import aluguelcarro.models.Carro;
import aluguelcarro.persistencia.dao.CarroDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public class JDBCCarroDAO extends AbstractJDBC implements CarroDAO{
    
    protected static final String COL_ID = "id";
    protected static final String COL_FABRICANTE = "fabricante";
    protected static final String COL_MODELO = "modelo";
    protected static final String COL_ANO = "ano";
    protected static final String COL_PLACA = "placa";
    protected static final String COL_SITUACAO = "situacao";
    
    
    @Override
    public void save(Carro carro) {
        String sql = "INSERT INTO " + TB_CARRO + "(" + COL_FABRICANTE + ", " + COL_MODELO + ", " + COL_ANO + ", " + COL_PLACA + ", " + COL_SITUACAO + ") VALUES (?, ?, ?, ?, ?)";

        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getFabricante());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setString(4, carro.getPlaca());
            
            if(carro.getSituacao() == null){
                carro.setSituacao("DISPONIVEL");
            }
            
            stmt.setString(5, carro.getSituacao());

            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Carro carro) {
        String sql = "DELETE FROM  " + TB_CARRO + " WHERE carro.id = ?";

        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, carro.getId());

            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Carro> findAll() {
        ArrayList<Carro> carros = new ArrayList<Carro>();
        String sql = "";
        sql = "SELECT " + 
                TB_CARRO + "." + COL_ID + "," + 
                TB_CARRO + "." + COL_FABRICANTE + "," + 
                TB_CARRO + "." + COL_MODELO + "," + 
                TB_CARRO + "." + COL_ANO + "," +
                TB_CARRO + "." + COL_PLACA + "," +
                TB_CARRO + "." + COL_SITUACAO +
             " FROM " + TB_CARRO;
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt(COL_ID));
                carro.setFabricante(rs.getString(COL_FABRICANTE));
                carro.setModelo(rs.getString(COL_MODELO));
                carro.setAno(rs.getInt(COL_ANO));
                carro.setPlaca(rs.getString(COL_PLACA));
                carro.setSituacao(rs.getString(COL_SITUACAO));
                carros.add(carro);
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carros;
    }

    @Override
    public Carro findById(int id) {
       Carro carro = new Carro();
        String sql = "";
        sql = "SELECT " + 
                TB_CARRO + "." + COL_ID + "," + 
                TB_CARRO + "." + COL_FABRICANTE + "," + 
                TB_CARRO + "." + COL_MODELO + "," + 
                TB_CARRO + "." + COL_ANO + "," +
                TB_CARRO + "." + COL_PLACA + "," +
                TB_CARRO + "." + COL_SITUACAO +
              " FROM " + TB_CARRO + " WHERE carro.id = ?";
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                carro.setId(rs.getInt(COL_ID));
                carro.setFabricante(rs.getString(COL_FABRICANTE));
                carro.setModelo(rs.getString(COL_MODELO));
                carro.setAno(rs.getInt(COL_ANO));
                carro.setPlaca(rs.getString(COL_PLACA));
                carro.setSituacao(rs.getString(COL_SITUACAO));
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carro;
    }

    @Override
    public Carro findByPlaca(String placa) {
        Carro carro = new Carro();
        String sql = "";
        sql = "SELECT " + 
                TB_CARRO + "." + COL_ID + "," + 
                TB_CARRO + "." + COL_FABRICANTE + "," + 
                TB_CARRO + "." + COL_MODELO + "," + 
                TB_CARRO + "." + COL_ANO + "," +
                TB_CARRO + "." + COL_PLACA + "," +
                TB_CARRO + "." + COL_SITUACAO +
              " FROM " + TB_CARRO + " WHERE carro.placa = ?";
        try {
            conexao = conexaoManager.abrirConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                carro.setId(rs.getInt(COL_ID));
                carro.setFabricante(rs.getString(COL_FABRICANTE));
                carro.setModelo(rs.getString(COL_MODELO));
                carro.setAno(rs.getInt(COL_ANO));
                carro.setPlaca(rs.getString(COL_PLACA));
                carro.setSituacao(rs.getString(COL_SITUACAO));
            }
            stmt.executeUpdate();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return carro;
    }
    
}
