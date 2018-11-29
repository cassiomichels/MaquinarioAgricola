package br.csi.dao;

import br.csi.model.Caminhoneiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CaminhoneiroDAO {

    public boolean update(Caminhoneiro caminhoneiro) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE caminhoneiro"
                    + " SET nome = ?,endereco = ?, placa =?"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, caminhoneiro.getNome());

            pre.setString(2, caminhoneiro.getEndereco());
            pre.setString(3, caminhoneiro.getPlaca());

            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Caminhoneiro read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM caminhoneiro"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Caminhoneiro c = new Caminhoneiro();
                c.setNome("nome");
                c.setEmail("email");
                c.setEndereco(rs.getString("endereco"));
                c.setPlaca(rs.getString("placa"));

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(Caminhoneiro caminhoneiro) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO caminhoneiro(nome, email, endereco, placa) "
                    + " VALUES(?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, caminhoneiro.getNome());
            pre.setString(2, caminhoneiro.getEmail());

            pre.setString(3, caminhoneiro.getEndereco());
            pre.setString(4, caminhoneiro.getPlaca());

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
            String sql = " DELETE FROM caminhoneiro"
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

    public ArrayList<Caminhoneiro> getCaminhoneiros() {
        ArrayList<Caminhoneiro> caminhoneiros = new ArrayList<>();

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM caminhoneiro ");
            while (rs.next()) {
                Caminhoneiro mot = new Caminhoneiro();
                mot.setId(rs.getInt("id"));
                mot.setNome(rs.getString("nome"));
                mot.setEmail(rs.getString("email"));
                mot.setEndereco(rs.getString("endereco"));
                mot.setPlaca(rs.getString("placa"));

                caminhoneiros.add(mot);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return caminhoneiros;
    }

}
