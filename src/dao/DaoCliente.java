/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Cliente;

/**
 *
 * @author UTFPR
 */
public interface DaoCliente {
    public void adicionar(Cliente cliente);
    public void remover(Cliente cliente);
    public void listarTodosClientes();
    public int verificaCliente(Cliente cliente);
}
