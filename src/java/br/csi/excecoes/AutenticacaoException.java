/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.excecoes;

/**
 *
 * @author aluno
 */
public class AutenticacaoException extends Exception
{
    
    public AutenticacaoException()
    {
        super("Erro de autenticação.");
    }
    
    public AutenticacaoException(String mensagem)
    {
        super(mensagem);
    }
}
