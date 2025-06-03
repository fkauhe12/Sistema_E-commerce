import model.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dados iniciais
        Endereco endereco = new Endereco("123", "Centro", "CidadeX", "EstadoY", "12345-678");
        Cliente cliente = new Cliente("João", "joao@email.com", endereco, "123.456.789-00", "99999-9999");
        Administrador admin = new Administrador("Maria", "maria@email.com", endereco, "987.654.321-00", "88888-8888");

        // Produtos disponíveis
        List<Produtos> estoque = new ArrayList<>();
        estoque.add(new Produtos("Notebook", "Notebook Gamer", 3500.0, 10, "Informática"));
        estoque.add(new Produtos("Mouse", "Mouse sem fio", 150.0, 50, "Acessórios"));
        estoque.add(new Produtos("Teclado", "Teclado Mecânico", 250.0, 30, "Acessórios"));

        Carrinho carrinho = new Carrinho(cliente);
        Pedido pedido = null;
        Pagamento pagamento = null;

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar produtos");
            System.out.println("2. Adicionar produto ao carrinho");
            System.out.println("3. Remover produto do carrinho");
            System.out.println("4. Ver carrinho");
            System.out.println("5. Criar pedido");
            System.out.println("6. Processar pagamento");
            System.out.println("7. Funcoes de Administrador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nProdutos disponíveis:");
                    for (int i = 0; i < estoque.size(); i++) {
                        Produtos p = estoque.get(i);
                        System.out.println(i + " - " + p.getNome() + " | R$" + p.getPreco());
                    }
                    break;
                case 2:
                    System.out.print("Digite o índice do produto para adicionar: ");
                    int idxAdd = sc.nextInt();
                    if (idxAdd >= 0 && idxAdd < estoque.size()) {
                        carrinho.adicionarProduto(estoque.get(idxAdd));
                        System.out.println("Produto adicionado ao carrinho.");
                    } else {
                        System.out.println("Indice invalido.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o indice do produto no carrinho para remover: ");
                    int idxRem = sc.nextInt();
                    if (idxRem >= 0 && idxRem < carrinho.getListaDeProdutos().size()) {
                        Produtos removido = carrinho.getListaDeProdutos().get(idxRem);
                        carrinho.removerProduto(removido);
                        System.out.println("Produto removido do carrinho.");
                    } else {
                        System.out.println("Indice invalido.");
                    }
                    break;
                case 4:
                    System.out.println("\nProdutos no carrinho:");
                    List<Produtos> lista = carrinho.getListaDeProdutos();
                    for (int i = 0; i < lista.size(); i++) {
                        Produtos p = lista.get(i);
                        System.out.println(i + " - " + p.getNome() + " | R$" + p.getPreco());
                    }
                    System.out.println("Total: R$" + carrinho.getTotal());
                    break;
                case 5:
                    if (carrinho.getListaDeProdutos().isEmpty()) {
                        System.out.println("Carrinho vazio!");
                    } else {
                        pedido = new Pedido(cliente, carrinho.getListaDeProdutos(), carrinho.getTotal());
                        System.out.println("Pedido criado. Status: " + pedido.getStatus());
                    }
                    break;
                case 6:
                    if (pedido == null) {
                        System.out.println("Crie um pedido primeiro.");
                    } else {
                        System.out.print("Forma de pagamento: ");
                        String forma = sc.nextLine();
                        pagamento = new Pagamento(pedido, forma);
                        pagamento.processar();
                        pagamento.confirmar();
                        System.out.println("Pagamento: " + pagamento.getStatus());
                    }
                    break;
                case 7:
                    System.out.println("\n--- ADMIN ---");
                    System.out.println("1. Cadastrar novo produto");
                    System.out.println("2. Gerar relatório");
                    System.out.print("Escolha: ");
                    int opAdmin = sc.nextInt();
                    sc.nextLine();
                    if (opAdmin == 1) {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        System.out.print("Quantidade: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Categoria: ");
                        String cat = sc.nextLine();
                        Produtos novo = new Produtos(nome, desc, preco, qtd, cat);
                        estoque.add(novo);
                        System.out.println("Produto cadastrado!");
                    } else if (opAdmin == 2) {
                        admin.gerarRelatorio();
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
