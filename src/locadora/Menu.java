package locadora;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import locadora.util.Cores;



public class Menu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		int opcao;
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND

					+ "**************************************************************");
			System.out.println("                                                              ");
			System.out.println("                                                              ");
			System.out.println("                   Locadora D.R.C                             ");
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
				System.out.print(Cores.TEXT_YELLOW +  Cores.ANSI_BLACK_BACKGROUND + "      ********************** **********************       ");
				System.out.println(
						
						Cores.TEXT_YELLOW +  Cores.ANSI_BLACK_BACKGROUND + "\n             Obrigado por usar a Locadora D.R.C!          ");
				sobre();
				sc.close();
				System.exit(0);
			}
			String nome, genero, personagem;
			int id, tipo=0;
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
					System.out.print("Digite o nome do genero Filme: ");
					sc.skip("\\R");
					genero = sc.nextLine();
	
					break;
				case 2:
					System.out.print("Digite o nome do personagem: ");
					sc.skip("\\R");
					nome = sc.nextLine();
					System.out.print("Digite o preço do " + nome + ":");
					preco = sc.nextFloat();
					System.out.print("Digite o tamanho do personagem: ");
					sc.skip("\\R");
					personagem = sc.nextLine();
					
					break;
				}
				keyPress();
				break;
			}
			case 2: {
				System.out.println("******************** Lista de Produtos ********************\n");
				
				keyPress();
				break;
			}
			case 3: {
				System.out.print("Digite o ID do Produto: ");
				id = sc.nextInt();
				
				keyPress();
				break;
			}

			case 4: {
				System.out.println("Digite o ID do Produto: ");
				id = sc.nextInt();

				

				
					System.out.println("Digite o novo nome do Produto: ");
					sc.skip("\\R");
					nome = sc.nextLine();
					System.out.println("Digite o novo preço do Produto: ");
					preco = sc.nextFloat();

					switch (tipo) {
					case 1:
						System.out.println("Digite o novo nome do Genérico do Medicamento: ");
						sc.skip("\\R");
						genero = sc.nextLine();
					
						break;
					case 2:
						System.out.println("Digite a nova fragrância: ");
						sc.skip("\\R");
						personagem = sc.nextLine();
						
						break;
					default:
						System.out.println("Tipo de Produto inválido!");

					}
				} 
			
			case 5: {
				System.out.println("Digite o ID do Produto: ");
				id = sc.nextInt();
				;
				keyPress();
			}
			
			}
		}
	}

	private static void sobre() {
		System.out.println("     ********************** **********************        ");
		System.out.println("                      Criado por                          ");
		System.out.println("                                                          ");
		System.out.println("                   Douglas Rosolini Correia               ");
		System.out.println("               https://github.com/douglasrc8              ");
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