package model;

import java.util.Date;

public class Pagamento {
    // Atributos
    private int id;
    private Pedido pedido;
    private String forma;
    private String status;
    private Date data;
    private static int contador = 1;

    // Construtor
    public Pagamento(Pedido pedido, String forma) {
        this.id = contador++;
        this.pedido = pedido;
        this.forma = forma;
        this.status = "Pendente";
        this.data = new Date();
    }

    // Métodos

    public void processar() {
        this.status = "Processando";
    }

    public void confirmar() {
        this.status = "Confirmado";
    }

    // Getters
    public int getId() {
        return id; 
    }
    public Pedido getPedido() { 
        return pedido; 
    }
    public String getForma() { 
        return forma; 
    }
    public String getStatus() { 
        return status; 
    }
    public Date getData() { 
        return data; 
    }
}
