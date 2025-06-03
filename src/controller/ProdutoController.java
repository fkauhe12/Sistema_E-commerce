package controller;

import model.Produtos;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produtos> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produtos produto) {
        produtos.add(produto);
    }

    public void removerProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
        }
    }

    public List<Produtos> listarProdutos() {
        return produtos;
    }

    public Produtos getProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.get(index);
        }
        return null;
    }
}
