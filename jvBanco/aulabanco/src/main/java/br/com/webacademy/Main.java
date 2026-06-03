package br.com.webacademy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
             exibirMenu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    SalvarProduto();
                    break;
                case 1:
                    buscarTodosProdutos();
                    break;
                case 2:
                    buscarProdutoPorId();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 0);
             sc.close();
    }
    private static void exibirMenu() {
            System.out.println("\n== Menu de Opções ==");
            System.out.println("\n0, Salvar novo produto ");
            System.out.println("\n1, Buscar todos produtos ");
            System.out.println("\n2, Buscar produtos por ID ");
            System.out.println("\n3, Atualizar produto ");
            System.out.println("\n5, Sair do programa ");
            System.out.print("Escolha uma opção: ");
        }
    private static void SalvarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n### Criar novo Produto ###");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Quantidade: ");
        int quantidade = sc.nextInt();
        System.out.println("Valor: ");
        double valor = sc.nextDouble();
        Produto produto = new Produto(nome,quantidade,valor);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        sc.close();
        try {
            produtoDAO.salvar(produto);
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
              
        }
    }

    private static void buscarTodosProdutos() {
        System.out.println("### Buscar todos os produtos");
        ProdutoDAO produtosDAO = new ProdutoDAO();
        try {
            List<Produto> produtos = produtosDAO.buscarTodos();
            if(produtos != null){
                System.out.println("Lista de Produtos: ");
                for(Produto produto : produto){

                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void buscarProdutoPorId() {
        System.out.println("### Buscar produtos pelo ID! ");
        System.out.println("Digite o ID do produto: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        try {
            Produto produto = produtoDAO.buscarPorItd(id);
            if(produto != null){
                System.out.println("Produto enconrado!");
                System.out.println(produto.nome);
            }
            else{
                System.out.println("Produto não encontrado!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}