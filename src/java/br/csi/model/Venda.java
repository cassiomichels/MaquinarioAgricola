/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.model;

import java.util.ArrayList;

public class Venda {

    private int id;
    private int id_cliente;
    private int id_caminhoneiro;
     private int id_produto;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_caminhoneiro() {
        return id_caminhoneiro;
    }

    public void setId_caminhoneiro(int id_caminhoneiro) {
        this.id_caminhoneiro = id_caminhoneiro;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Venda(int id, int id_cliente, int id_caminhoneiro, int id_produto, String endereco) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_caminhoneiro = id_caminhoneiro;
        this.id_produto = id_produto;
        this.endereco = endereco;
    }

    public Venda(int id_cliente, int id_caminhoneiro, int id_produto, String endereco) {
        this.id_cliente = id_cliente;
        this.id_caminhoneiro = id_caminhoneiro;
        this.id_produto = id_produto;
        this.endereco = endereco;
    }

    public Venda() {
    }

    public Venda(int id_cliente, int id_caminhoneiro, int id_produto) {
        this.id_cliente = id_cliente;
        this.id_caminhoneiro = id_caminhoneiro;
        this.id_produto = id_produto;
    }

   
    

}
