package model;


public class Produto {
    private int codigo;
    private String nome;
    private double preco, quantidade;
    private Categoria categoria;
    private boolean perecivel;

    public Produto() {
    }

    public Produto(String nome) {
        this.nome = nome;
    }
  
    public Produto(String nome, double preco, double quantidade, Categoria categoria, boolean perecivel) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.perecivel = perecivel;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean getPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }
    
    
}
