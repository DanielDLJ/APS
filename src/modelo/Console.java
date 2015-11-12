/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author UTFPR
 */
public class Console {
    private String nome;
    private String fabricante;
    private int id;
    public Console(){
        
    }
    public Console(String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public Console(int id, String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }
    
    
}
