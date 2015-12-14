package aluguelcarro.persistencia.jdbc;

import aluguelcarro.persistencia.dao.AluguelDAO;
import aluguelcarro.persistencia.dao.CarroDAO;
import aluguelcarro.persistencia.dao.ClienteDAO;
import aluguelcarro.persistencia.factory.Factory;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public class JDBCFactory implements Factory{

    @Override
    public ClienteDAO createClienteDAO() {
        return new JDBCCLienteDAO();
    }

    @Override
    public CarroDAO createCarroDAO() {
        return new JDBCCarroDAO();
    }

    @Override
    public AluguelDAO createAluguelDAO() {
        return new JDBCAluguelDAO();
    }
}
