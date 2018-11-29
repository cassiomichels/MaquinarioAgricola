
package br.csi.model;


public class Caminhoneiro extends Funcionario {
  private int id;
  private String endereco;
  private String placa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

  
    public Caminhoneiro(int id, String nome, String email, String endereco, String placa) {
        super(nome, email);
        this.id = id;
        this.endereco = endereco;
        this.placa = placa;
    }

    public Caminhoneiro(String nome, String email, String endereco, String placa ) {
        super(nome, email);
        this.endereco = endereco;
        this.placa = placa;
    }

    public Caminhoneiro() {
    }


  


    
}
