package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    // Atributos
    private int id;
    private Cliente cliente;
    private List<Produtos> listaDeProdutos;
    private double total;
    private static int contador = 1;

    // Construtor

    public Carrinho(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.listaDeProdutos = new ArrayList<>();
        this.total = 0.0;
    }

    // Métodos
   
    public void adicionarProduto(Produtos produto) {
        listaDeProdutos.add(produto);
        calcularTotal();
    }

    public void removerProduto(Produtos produto) {
        listaDeProdutos.remove(produto);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0.0;
        for (Produtos p : listaDeProdutos) {
            total += p.getPreco();
        }
    }

    // Getters
    public double getTotal() {
        return total;
    }

    public List<Produtos> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }
}
