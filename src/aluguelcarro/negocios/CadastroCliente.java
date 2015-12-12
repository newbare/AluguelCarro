/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguelcarro.negocios;

import aluguelcarro.models.Cliente;

/**
 *
 * @author eriss_000
 */
public class CadastroCliente {
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
    
    public boolean inserirCliente(Cliente cliente){
        boolean camposValidados = this.validarDados(cliente);
        if(camposValidados){
            //TODO chamar o inserir
            this.mensagem = "Aguardando o metodo inserir cliente";
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
