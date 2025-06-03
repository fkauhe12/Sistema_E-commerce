package model;

public class Administrador extends Cliente {
    //constructor
    public Administrador(String nome, String email, Endereco endereco, String cpf, String telefone) {
        super(nome, email, endereco, cpf, telefone);
    }

    // Métodos de administrador

    public void cadastrarProduto() {
        System.out.println("Produto cadastrado pelo administrador.");
    }

    public void gerarRelatorio() {
        System.out.println("Relatório gerado pelo administrador.");
    }
}
