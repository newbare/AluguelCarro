package aluguelcarro.persistencia.dao;

import aluguelcarro.models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public interface ClienteDAO {
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public ArrayList<Cliente> findAll();
    public Cliente findById(int id);
    public Cliente findByName(String name);
}
