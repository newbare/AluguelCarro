package aluguelcarro.facade;

import aluguelcarro.models.Aluguel;
import aluguelcarro.models.Carro;
import aluguelcarro.models.Cliente;
import aluguelcarro.persistencia.dao.CarroDAO;
import aluguelcarro.persistencia.jdbc.JDBCFactory;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public class AluguelCarroFacade {
    
    public static JDBCFactory jdbcFactory = new JDBCFactory();
    //public static Object factory = (JDBCFactory)jdbcFactory;
   
    public static void criarCarro(Carro carro) throws SQLException{
       jdbcFactory.createCarroDAO().save(carro);
    }
    
    public static void criarCliente(Cliente cliente) throws SQLException{
       jdbcFactory.createClienteDAO().save(cliente);
    }
    
    public static void criarAluguel(Aluguel aluguel) throws SQLException{
       jdbcFactory.createAluguelDAO().save(aluguel);
    }    
    
    public static ArrayList<Carro> retornaTodosCarros() throws SQLException{
        return jdbcFactory.createCarroDAO().findAll();
    }
    
    public static ArrayList<Cliente> retornaTodosClientes() throws SQLException{
        return jdbcFactory.createClienteDAO().findAll();
    }
    
    public static ArrayList<Aluguel> retornaTodosAluguel() throws SQLException{
        return jdbcFactory.createAluguelDAO().findAll();
    }
    
}
