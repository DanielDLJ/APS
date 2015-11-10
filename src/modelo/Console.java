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

    public Console(String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }


    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }
    
    
}
