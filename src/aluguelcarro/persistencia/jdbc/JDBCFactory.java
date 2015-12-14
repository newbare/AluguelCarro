package aluguelcarro.persistencia.jdbc;

import aluguelcarro.persistencia.dao.AluguelDAO;
import aluguelcarro.persistencia.dao.CarroDAO;
import aluguelcarro.persistencia.dao.ClienteDAO;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public class JDBCFactory {
    public static ClienteDAO createClienteDAO(){
        return new JDBCCLienteDAO();
    }
    
    public static CarroDAO createCarroDAO(){
        return new JDBCCarroDAO();
    }
    
    public static AluguelDAO createAluguelDAO(){
        return new JDBCAluguelDAO();
    }
}
