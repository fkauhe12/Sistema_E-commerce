package model;

public class Cliente extends Pessoa {
    private int id;
    private String cpf;
    private String telefone;
    private static int contador = 1;
    private String senha = "1234";

    public Cliente(String nome, String email, Endereco endereco, String cpf, String telefone) {
        super(nome, email, endereco);
        this.id = contador++;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters and Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    // metodos
    public boolean login(String senha) {
        return this.senha.equals(senha);
    }

    public Pedido fazerPedido(Carrinho carrinho) {
        if (carrinho.getListaDeProdutos().isEmpty()) {
            System.out.println("Carrinho vazio!");
            return null;
        }
        Pedido pedido = new Pedido(this, carrinho.getListaDeProdutos(), carrinho.getTotal());
        System.out.println("Pedido realizado. Status: " + pedido.getStatus());
        return pedido;
    }

    public void cancelarPedido(Pedido pedido) {
        if (pedido != null) {
            pedido.cancelar();
            System.out.println("Pedido cancelado.");
        }
    }

}
