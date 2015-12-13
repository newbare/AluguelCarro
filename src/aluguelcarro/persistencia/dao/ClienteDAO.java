/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aluguelcarro.persistencia.dao;

import aluguelcarro.models.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro H M dos Santos <phmsanttos@gmail.com>
 */
public interface ClienteDAO {
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public void update(Cliente cliente);
    public ArrayList<Cliente> findAll();
    public Cliente findById(int id);
    public Cliente findByName(String name);
}
