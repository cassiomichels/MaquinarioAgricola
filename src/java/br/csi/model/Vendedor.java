
package br.csi.model;


public class Vendedor extends Funcionario implements Autenticavel {
    private int id;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


  

    public Vendedor(int id, String nome, String email, String senha) {
        super(nome, email);
        this.senha = senha;
        this.id = id;
    }

    public Vendedor( String nome, String email,String senha) {
        super(nome, email);
        this.senha = senha;
    }

    public Vendedor() {
    }

   
    
}

