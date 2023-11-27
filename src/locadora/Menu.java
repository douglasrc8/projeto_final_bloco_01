package locadora;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import locadora.util.Cores;

import locadora.controller.ProdutoController;
import locadora.model.Filme;
import locadora.model.Personagem;
import locadora.model.Produto;


public class Menu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();

		Filme filme = new Filme(produtos.gerarId(), "Age of Empires", 1, 30.0, "Ação");
		produtos.criarProduto(filme);

		Personagem personagem = new Personagem(produtos.gerarId(), "Floral Age of Empires", 2, 8.0, "Tamanho P");
		produtos.criarProduto(personagem);

		int opcao;
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND

					+ "**************************************************************");
			System.out.println("                                                              ");
			System.out.println("                                                              ");
			System.out.println("                       D.R.C LOCADORA                         ");
			System.out.println("                                                              ");
			System.out.println(" ************************************************************ ");
			System.out.println("                                                              ");
			System.out.println("                   1 - Cadastrar Produto                      ");
			System.out.println("                   2 - Listar todos os Produtos               ");
			System.out.println("                   3 - Consultar Produto por ID               ");
			System.out.println("                   4 - Atualizar Produto                      ");
			System.out.println("                   5 - Deletar Produto                        ");
			System.out.println("                   6 - Sair                                   ");
			System.out.println("                                                              ");
			System.out.println(" ************************************************************ ");
			System.out.println("                   Entre com a opção desejada:                ");
			System.out.println("                                                              " + Cores.TEXT_RESET);

			// trata erros de entrada da opcao
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}
			// para sair do programa
			if (opcao == 6) {
				System.out.print(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "      ********************** **********************       ");
				System.out.println(

						Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
								+ "\n     OBRIGADO POR ADQUIRIR OS PRODUTOS DA NOSSA LOJA      ");
				sobre();
				sc.close();
				System.exit(0);
			}
			String nome, Filme, Personagem;
			int id, tipo = 0;
			double preco;

			switch (opcao) {
			case 1: {

				System.out.println("Digite o tipo do Produto\n1 - Filme\n2 - Personagem ");
				System.out.print("tipo: ");
				tipo = sc.nextInt();

				switch (tipo) {
				case 1:
					System.out.print("Digite o nome do Filme: ");
					sc.skip("\\R");
					nome = sc.nextLine();
					System.out.print("Digite o preço do " + nome + ":");
					preco = sc.nextFloat();
					System.out.print("Digite o genero desse Filme: ");
					sc.skip("\\R");
					Filme = sc.nextLine();
					produtos.criarProduto(new Filme(produtos.gerarId(), nome, tipo, preco, Filme));
					break;
				case 2:
					System.out.print("Digite o nome do personagem: ");
					sc.skip("\\R");
					nome = sc.nextLine();
					System.out.print("Digite o preço do " + nome + ":");
					preco = sc.nextFloat();
					System.out.print("Digite o tamanho do Personagem: ");
					sc.skip("\\R");
					Personagem = sc.nextLine();
					produtos.criarProduto(new Personagem(produtos.gerarId(), nome, tipo, preco, Personagem));
					break;
				}
				keyPress();
				break;
			}
			case 2: {
				System.out.println("******************** Lista de Produtos ********************\n");
				produtos.listarProdutos();
				keyPress();
				break;
			}
			case 3: {
				System.out.print("Digite o ID do Produto: ");
				id = sc.nextInt();
				produtos.consultarPorId(id);
				keyPress();
				break;
			}

			case 4: {
				System.out.println("Digite o ID do Produto: ");
				id = sc.nextInt();

				Optional<Produto> produto = produtos.buscarNaCollection(id);

				if (produto.isPresent()) {
					tipo = produto.get().getTipo();
					System.out.println("Digite o novo nome do Produto: ");
					sc.skip("\\R");
					nome = sc.nextLine();
					System.out.println("Digite o novo preço do Produto: ");
					preco = sc.nextFloat();

					switch (tipo) {
					case 1:
						System.out.println("Digite o novo genero do filme: ");
						sc.skip("\\R");
						Filme = sc.nextLine();

						break;
					
					case 2:
						System.out.println("Digite o novo Personagem: ");
						sc.skip("\\R");
						Personagem = sc.nextLine();
								
						break;
					default:
						System.out.println("Tipo de Produto inválido!");

					}
				} else {
					System.out.println("Produto não encontrado!");
					keyPress();
					break;
				}
			}
			case 5: {
				System.out.println("Digite o ID do Produto: ");
				id = sc.nextInt();
				produtos.deletarProduto(id);
				keyPress();
			}
			}
		}

	}

	private static void sobre() {
		System.out.println("     ********************** **********************        ");
		System.out.println("                      Criado por                          ");
		System.out.println("                                                          ");
		System.out.println("                 Douglas Rosolini Correia                 ");
		System.out.println("              https://github.com/douglasrc8               ");
		System.out.println("                                                          ");
		System.out.println("     ********************** **********************        ");

	}

	public static void keyPress() {
		try {
			System.out.println("\nPressione Enter para Continuar");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter");
		}
	}
}