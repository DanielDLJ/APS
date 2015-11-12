/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.*;
import dao.ClienteDaoDerby;
import dao.DaoCliente;
import javax.swing.JOptionPane;

/**
 *
 * @author UTFPR
 */
public class Locacao {
    Cliente cliente;
    DaoCliente daoCliente;
    LocalDate agora = LocalDate.now();
    int id;
    String s;
    public Locacao(){
        daoCliente = new ClienteDaoDerby();
        cliente = new Cliente();
    }
    public void novaLocacao(){
        id = daoCliente.verificaCliente(cliente);
        String nome;
        nome = JOptionPane.showInputDialog("Para qual pessoa quer inicar a locacao:");
        if(nome == null){
            JOptionPane.showMessageDialog(null,"Voce cancelou saindo da Nova Locacao");
            return;
        }
        if(id==-1){
            System.out.println("Esse nome de cliente não existe.");
            s = JOptionPane.showInputDialog("Quer Adicionar essa pessoa "+nome+" ?");
            if(s == null)
                JOptionPane.showMessageDialog(null,"Voce cancelou");
        }
    }
    
}
