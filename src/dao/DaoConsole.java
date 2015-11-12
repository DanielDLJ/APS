/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Console;

/**
 *
 * @author UTFPR
 */
public interface DaoConsole {
    public void adicionar(Console console);
    public void remover(Console console);
    public void listarTodosConsoles();
    public int verificaConsole(Console console);
    public Console getConsole(int idConsole);
}
