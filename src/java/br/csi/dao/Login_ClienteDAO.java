package br.csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_ClienteDAO {

    public boolean autenticar(String email, String senha){
        
       try(Connection conn = 
                    new ConectaDB_Postgres().getConexao() ){
           
           String sql = " SELECT * FROM cliente "
                   + " WHERE email = ? AND senha = ?";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           pStmt.setString(1, email);
           pStmt.setString(2, senha);
           ResultSet rs = pStmt.executeQuery();
           while(rs.next()){
               return true;
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }
        
        return false;
    }
    
}
