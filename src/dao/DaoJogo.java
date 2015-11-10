/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Console;
import modelo.Jogo;

/**
 *
 * @author UTFPR
 */
public interface DaoJogo {
    public void adicionar(Jogo jogo,Console console);
    public void remover(Jogo jogo);
    public void listarTodosJogos();
}
