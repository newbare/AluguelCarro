/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguelcarro.negocios;

import aluguelcarro.facade.AluguelCarroFacade;
import aluguelcarro.models.Aluguel;
import aluguelcarro.models.Carro;
import aluguelcarro.models.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eriss_000
 */
public class CadastroAluguel {
    private ArrayList<Carro> listaCarros;
    private ArrayList<Cliente> listaClientes;
    private String mensagem;
    AluguelCarroFacade facade = new AluguelCarroFacade();
    private ArrayList<Aluguel> listaAlugueis = new ArrayList<Aluguel>();
    
    public CadastroAluguel() {
        
        try {
            this.listaCarros = facade.retornaTodosCarros();
            this.listaClientes = facade.retornaTodosClientes();
            this.listaAlugueis = facade.retornaTodosAluguel();
        } catch (SQLException ex) {
            this.mensagem = "Erro ao carregar dados do carro e cliente";
        }
       
    }
    
    public boolean validarDados(Aluguel aluguel){
        
        if(aluguel.getDtInicio().equals("")){
            this.mensagem = "Por Favor informe uma data de incio!";
            return false;
        }
        if(aluguel.getDtFim().equals("")){ 
            this.mensagem = "Por Favor informe uma data para fim!";
            return false;
        }
        if(aluguel.getCliente().getId() == 0){
            this.mensagem = "Por Favor informe um cliente!";
            return false;
        }
        if(aluguel.getCarro().getId() == 0){
            this.mensagem = "Por Favor informe um carro!";
            return false;
        }
        
        return true;
    }
    
     public boolean inserirAluguel(Aluguel aluguel) throws SQLException{
        boolean camposValidados = this.validarDados(aluguel);
        if(camposValidados){
            try {
                facade.criarAluguel(aluguel); 
                this.mensagem = "Aluguel cadastrado com sucesso!";
            } catch (SQLException e) {
                this.mensagem = "Erro ao inserir o aluguel!";
            }
            
            return true;
        }
        
        return false;
    }

    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(ArrayList<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ArrayList<Aluguel> getListaAlugueis() {
        return listaAlugueis;
    }

    public void setListaAlugueis(ArrayList<Aluguel> listaAlugueis) {
        this.listaAlugueis = listaAlugueis;
    }
    
}
