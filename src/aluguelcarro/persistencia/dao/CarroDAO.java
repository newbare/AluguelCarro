package aluguelcarro.persistencia.dao;

import aluguelcarro.models.Carro;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public interface CarroDAO {
    public void save(Carro carro);
    public void delete(Carro carro);
    public ArrayList<Carro> findAll();
    public Carro findById(int id);
    public Carro findByPlaca(String placa);
}
