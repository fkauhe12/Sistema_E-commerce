package model;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produtos> produtos;
    private Date data;
    private String status;
    private double valorTotal;
    private static int contador = 1;

    public Pedido(Cliente cliente, List<Produtos> produtos, double valorTotal) {
        this.id = contador++;
        this.cliente = cliente;
        this.produtos = produtos;
        this.data = new Date();
        this.status = "Pendente";
        this.valorTotal = valorTotal;
    }

    // Getters
    public int getId() { 
        return id; 
    }
    public Cliente getCliente() { 
        return cliente; 
    }
    public List<Produtos> getProdutos() { 
        return produtos; 
    }
    public Date getData() { 
        return data; 
    }
    public String getStatus() { 
        return status; 
    }
    public double getValorTotal() { 
        return valorTotal; 
    }

    // Métodos
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void cancelar() {
        this.status = "Cancelado";
    }

}
