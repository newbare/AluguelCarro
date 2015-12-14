package aluguelcarro.persistencia.factory;

import aluguelcarro.persistencia.dao.AluguelDAO;
import aluguelcarro.persistencia.dao.CarroDAO;
import aluguelcarro.persistencia.dao.ClienteDAO;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public interface Factory {
    ClienteDAO createClienteDAO();
    CarroDAO createCarroDAO();
    AluguelDAO createAluguelDAO();
}
