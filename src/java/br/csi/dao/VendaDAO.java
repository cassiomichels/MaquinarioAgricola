package br.csi.dao;


import br.csi.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendaDAO {

  
     
     
     
    public boolean update(Venda pedido) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE pedido"
                    + " SET id_cliente = ?, id_caminhoneiro =?, id_praduto =?, endereco =? "
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, pedido.getId_cliente());
            pre.setInt(2, pedido.getId_caminhoneiro());
            pre.setInt(3, pedido.getId_produto());
            pre.setString(4, pedido.getEndereco());


            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public Venda read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM pedido"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Venda p = new Venda();
                p.setId_cliente(rs.getInt("id_cliente"));
                p.setId(rs.getInt("id_caminhoneiro"));
                p.setId(rs.getInt("id_produto"));
                p.setEndereco(rs.getString("endereco"));
                

                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean create(Venda pedido) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO pedido(id_cliente, id_caminhoneiro, id_produto, endereco) "
                    + " VALUES(?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, pedido.getId_cliente());
            pre.setInt(2, pedido.getId_caminhoneiro());
            pre.setInt(3, pedido.getId_produto());
            pre.setString(4, pedido.getEndereco());

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " DELETE FROM pedido"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Venda> getVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        // Connection conn = new ConectaDB_Postgres().getConexao();
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pedido");
            while (rs.next()) {
                Venda ped = new Venda();
                ped.setId(rs.getInt("id"));
                ped.setId_cliente(rs.getInt("id_cliente"));
                ped.setId_caminhoneiro(rs.getInt("id_caminhoneiro"));
                ped.setId_produto(rs.getInt("id_produto"));
                ped.setEndereco(rs.getString("endereco"));
                

                vendas.add(ped);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendas;
    }

}
