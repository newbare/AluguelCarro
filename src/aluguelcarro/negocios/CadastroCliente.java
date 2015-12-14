/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguelcarro.negocios;

import aluguelcarro.facade.AluguelCarroFacade;
import aluguelcarro.models.Cliente;
import java.sql.SQLException;

/**
 *
 * @author eriss_000
 */
public class CadastroCliente {
    AluguelCarroFacade facade = new AluguelCarroFacade();
    private String mensagem;

     public boolean validarDados(Cliente cliente){
        
        if(cliente.getNome().equals("")){ 
            this.mensagem = "Por Favor informe o nome do cliente!";
            return false;
        }
        if(cliente.getCpf().equals("")){ 
            this.mensagem = "Por Favor informe o cpf do cliente!";
            return false;
        }
        if(cliente.getTelefone().equals("")){ 
            this.mensagem = "Por Favor informe o telefone do cliente!";
            return false;
        }
        
        return true;
    }
    
    public boolean inserirCliente(Cliente cliente) throws SQLException{
        boolean camposValidados = this.validarDados(cliente);
        if(camposValidados){
            //TODO chamar o inserir
            
            try {
                facade.criarCliente(cliente);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                this.mensagem = "Usuário cadastrado com sucesso! (:";
            }
            
            return true;
        }
        
        return false;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
