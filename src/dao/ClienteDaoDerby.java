/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;
import modelo.Console;

/**
 *
 * @author UTFPR
 */
public class ClienteDaoDerby implements DaoCliente{
    Statement stmt;
    
    @Override
    public void adicionar(Cliente cliente) {
        
    }

    @Override
    public void remover(Cliente cliente) {
        
    }

    @Override
    public void listarTodosClientes() {
        
    }

    @Override
    public int verificaCliente(Cliente cliente) {
        String instrucao = "SELECT* FROM CONSOLE";
        Console console = new Console("nada","nada");
        int aux=-1;
        try{
            ResultSet rs = stmt.executeQuery(instrucao);
            while(rs.next()){
                int id = rs.getInt("CONSOLEID");
                String nome = rs.getString("NOME");
                if(rs.getString("NOME").equalsIgnoreCase(cliente.getNome())){
                    aux =id;
                    break;
                }
            }
        }catch(SQLException se){
            System.out.println("Mensagem: "+se.getMessage());
        }
        return aux;
    }
    
}
