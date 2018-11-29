/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.servicos;

import br.csi.dao.ClienteDAO;
import br.csi.dao.ConectaDB_Postgres;
import br.csi.dao.VendedorDAO;
import br.csi.excecoes.AutenticacaoException;
import br.csi.model.Autenticavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Autenticador {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private VendedorDAO vendedorDAO = new VendedorDAO();
    public Autenticador()
    {
       
    }
    //Cliente e Vendedor precisam implementar a interface Autenticavel
    public Autenticavel autenticar(String email, String senha) throws AutenticacaoException
    {
        if(autenticarCliente(email, senha))
        {
            return (Autenticavel) clienteDAO.read(email, senha);
        }
        else if(autenticarVendedor(email, senha))
        {
            return (Autenticavel) vendedorDAO.read(email, senha);
        }
        throw new AutenticacaoException();
    }
    
    private boolean autenticarVendedor(String email, String senha)
    {
        Connection conn = null;
        try
        {
           conn = new ConectaDB_Postgres().getConexao();
           String sql = " SELECT * FROM vendedor WHERE email = ? AND senha = ?";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           pStmt.setString(1, email);
           pStmt.setString(2, senha);
           ResultSet rs = pStmt.executeQuery();
           return rs.next();
          
        }
        catch(SQLException e)
        {
           e.printStackTrace();
           return false;
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
        
    }
    
    private boolean autenticarCliente(String email, String senha)
    {
        Connection conn = null;
        try
        {
           conn = new ConectaDB_Postgres().getConexao();
           String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           pStmt.setString(1, email);
           pStmt.setString(2, senha);
           ResultSet rs = pStmt.executeQuery();
           return rs.next();
           
       }
        catch(SQLException e){
           e.printStackTrace();
           return false;
       }
       finally
       {
            try {
                conn.close();
            } catch (SQLException ex) {
               
            }
       }
    }
    
    
}
