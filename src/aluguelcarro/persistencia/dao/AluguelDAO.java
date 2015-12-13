package aluguelcarro.persistencia.dao;

import aluguelcarro.models.Aluguel;
import aluguelcarro.models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public interface AluguelDAO {
    public void save(Aluguel aluguel);
    public ArrayList<Aluguel> findAll();
    public Aluguel findByCliente(Cliente cliente);
    
}
