package aluguelcarro.persistencia.jdbc;
import java.sql.Connection;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */

import aluguelcarro.persistencia.connection.ConnectionManager;

public abstract class AbstractJDBC {
	protected ConnectionManager conexaoManager;
	protected Connection conexao;
	protected AbstractJDBC(){
		conexaoManager = ConnectionManager.getInstancia();
	}
	
	protected final String DATABASE = "aluguel";
	protected final String TB_CLIENTE = "cliente"; 
	protected final String TB_CARRO = "carro";
	protected final String TB_ALUGUEL = "aluguel";	
	
}
