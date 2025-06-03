package model;

public class Produtos {
    // Atributos
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String categoria;
    private static int contador = 1;

    // Construtor
    public Produtos(String nome, String descricao, double preco, int estoque, String categoria) {
        this.id = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    // Metodos
    public void atualizarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.estoque += quantidade;
        } else if (quantidade < 0 && this.estoque + quantidade >= 0) {
            this.estoque += quantidade;
        } else {
            System.out.println("Quantidade invalida para atualizar o estoque.");
        }
    }
    
}
