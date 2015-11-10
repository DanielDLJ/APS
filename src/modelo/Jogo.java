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
public class Jogo {
    private String nome;
    private String categoria;
    private float precoLocacao;
    private Console console;

    public Jogo(String nome, String categoria, float precoLocacao,String nomeConsole,String nomeFabricante) {
        console = new Console(nomeConsole,nomeFabricante);
        
        this.nome = nome;
        this.categoria = categoria;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPrecoLocacao() {
        return precoLocacao;
    }
    
    
}
