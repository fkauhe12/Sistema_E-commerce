package controller;

import model.Carrinho;
import model.Produtos;

public class CarrinhoController {
    private Carrinho carrinho;

    public CarrinhoController(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void adicionarProduto(Produtos produto) {
        carrinho.adicionarProduto(produto);
    }

    public void removerProduto(Produtos produto) {
        carrinho.removerProduto(produto);
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }
}
