package model;

public class Administrador extends Cliente {
    public Administrador(String nome, String email, Endereco endereco, String cpf, String telefone) {
        super(nome, email, endereco, cpf, telefone);
    }

    public void cadastrarProduto() {
        System.out.println("Produto cadastrado pelo administrador.");
    }

    public void gerarRelatorio() {
        System.out.println("Relatório gerado pelo administrador.");
    }
}
