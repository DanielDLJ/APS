/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Console;
import modelo.Jogo;

/**
 *
 * @author UTFPR
 */
public class JogoDaoDerby implements DaoJogo{
    Statement stmt;
    
    public JogoDaoDerby() {
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
    public void adicionar(Jogo jogo,Console console) {
        DaoConsole dao = new ConsoleDaoDerby();
        int aux = dao.verificaConsole(console);
        if(aux==-1){
            dao.adicionar(console);
            aux=dao.verificaConsole(console);
        }
        String instrucao = "INSERT INTO JOGO(NOME,CONSOLEID, CATEGORIA,PRECOLOCACAO) VALUES (" 
                +"'" + jogo.getNome()+ "',"
                +"'" + aux+ "',"
                +"'" + jogo.getCategoria()+"',"
                +"'" + jogo.getPrecoLocacao()+")";
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);    
        }
    }

    @Override
    public void remover(Jogo jogo) {
        String instrucao = "DELETE FROM CONSOLE WHERE NOME LIKE '%" + jogo.getNome()+"%'";
        
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);
        }
    }

    @Override
    public void listarTodosJogos() {
        String instrucao;
        try {
            instrucao = "SELECT* FROM JOGO";
            ResultSet rs = stmt.executeQuery(instrucao);
            int id;
            
            while(rs.next()){
                id = rs.getInt("JOGOID");
                DaoConsole dao = new ConsoleDaoDerby();
                Console console = dao.getConsole(id);
                System.out.println("    JOGO\nNome: " + rs.getString("NOME")
                        + "   Categoria: " + rs.getString("CATEGORIA")
                        + "   Preco Locacao: "+rs.getFloat("PRECO")
                        + "   Console nome: "+console.getNome()
                        + "   Console fabricante: "+console.getFabricante());
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
    
}
