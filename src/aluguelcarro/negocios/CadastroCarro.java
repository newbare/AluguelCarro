/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguelcarro.negocios;

import aluguelcarro.facade.AluguelCarroFacade;
import aluguelcarro.models.Carro;
import java.sql.SQLException;

/**
 *
 * @author eriss_000
 */
public class CadastroCarro {
    AluguelCarroFacade facade = new AluguelCarroFacade();
    private String mensagem;
    
    public boolean validarDados(Carro carro){
        
        if(carro.getFabricante().equals("")){
            this.mensagem = "Por Favor informe o fabricante do carro!";
            return false;
        }
        if(carro.getModelo().equals("")){
            this.mensagem = "Por Favor informe o modelo do carro!";
            return false;
        }
        if(carro.getPlaca().equals("")){
            this.mensagem = "Por Favor informe a placa do carro!";
            return false;
        }
        if(carro.getAno() == 0){
            this.mensagem = "Por Favor informe o ano do carro!";
            return false;
        }
        
        return true;
    }
    
    public boolean inserirCarro(Carro carro) throws SQLException{
        boolean camposValidados = this.validarDados(carro);
        if(camposValidados){
            try {
                facade.criarCarro(carro);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                this.mensagem = "Carro cadastrado com sucesso! (:";
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
