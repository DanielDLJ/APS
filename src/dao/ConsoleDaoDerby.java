/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import modelo.Cliente;
import modelo.Console;

/**
 *
 * @author UTFPR
 */
public class ConsoleDaoDerby implements DaoConsole{
    Statement stmt;

    public ConsoleDaoDerby() {
        String username = "daniel";
        String password = "123";
        String url= "jdbc:derby://localhost:1527/MeuBancoDeDados";
        //depois disso, posso mandar conectar
        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("Conexão estabelecida");
        } catch (SQLException se) {
            System.out.println("Mensagem: "+ se.getMessage());
        }
    }
    
    @Override
    public void adicionar(Console console) {
        String instrucao = "INSERT INTO CONSOLE(NOME,FABRICANTE) VALUES (" 
                +"'" + console.getNome()+ "',"
                +"'" + console.getFabricante()+ ")";
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);    
        }
    }

    @Override
    public void remover(Console console) {
        String instrucao = "DELETE FROM CONSOLE WHERE NOME LIKE '%" + console.getNome()+"%'";
        
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);
            
        }
    }

    @Override
    public void listarTodosConsoles() {
        String instrucao = "SELECT* FROM CONSOLE";
        try {
            
            ResultSet rs = stmt.executeQuery(instrucao);
            
            while(rs.next()){
                System.out.println("Nome: " + rs.getString("NOME")
                        + "   Fabricante: " + rs.getString("FABRICANTE"));
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }
    }

    @Override
    public int verificaConsole(Console console) {
        String instrucao = "SELECT* FROM CONSOLE";
        try {
            
            ResultSet rs = stmt.executeQuery(instrucao);
            
            while(rs.next()){
                if(rs.getString("NOME").equalsIgnoreCase(console.getNome())){
                    return rs.getInt("CONSOLEID");
                }
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }
        return -1;
    }

    @Override
    public Console getConsole(int idConsole) {
        
        String instrucao = "SELECT* FROM CONSOLE";
        Console console = new Console("nada","nada");
        int cont=0;
        try{
            ResultSet rs = stmt.executeQuery(instrucao);
            while(rs.next()){
                int id = rs.getInt("CONSOLEID");
                String nome = rs.getString("NOME");
                String fabricante = rs.getString("FABRICANTE");
                if(id==idConsole){
                    console = new Console(nome,fabricante);
                    break;
                }
            }
        }catch(SQLException se){
            System.out.println("Mensagem: "+se.getMessage());
        }
        return console;
    }

    
    
}
