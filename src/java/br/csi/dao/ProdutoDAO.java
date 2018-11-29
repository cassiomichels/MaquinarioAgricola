package br.csi.dao;

import br.csi.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutoDAO {

    public int create(String nome, String descricao) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " INSERT INTO produto(nome, descricao) "
                    + " VALUES(?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, nome);
            pre.setString(2, descricao);

            pre.execute();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();

            if (rs.getInt(1) > 0) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Produto produto) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO produto(nome, descricao)"
                    + " VALUES(?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, produto.getNome());
            pre.setString(2, produto.getDescricao());

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Produto read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM produto"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Produto u = new Produto();
                u.setNome(rs.getString("nome"));
                u.setDescricao(rs.getString("descricao"));

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Produto produto) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE Produto"
                    + " SET nome = ?, descricao = ?"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, produto.getNome());
            pre.setString(2, produto.getDescricao());

            pre.setInt(3, produto.getId());
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
            String sql = " DELETE FROM produto"
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

    public ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        // Connection conn = new ConectaDB_Postgres().getConexao();
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *  FROM produto");
            while (rs.next()) {
                Produto us = new Produto();
                us.setId(rs.getInt("id"));
                us.setNome(rs.getString("nome"));
                us.setDescricao(rs.getString("descricao"));

                produtos.add(us);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produtos;
    }

}
