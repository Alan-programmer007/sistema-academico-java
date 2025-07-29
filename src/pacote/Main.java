package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Aluno> bancoAluno = new ArrayList<Aluno>(); 
		int opcao = 0;
		
		do {
			opcao = menu(entrada);
			
			switch (opcao) {
			case 1:
				cadastrar(entrada, bancoAluno);
				break;
			case 2:
				listar(bancoAluno);
				break;
			case 3:
				buscar(entrada, bancoAluno);
				break;
			case 4:
				editar(entrada, bancoAluno);
				break;
			case 5:
				excluir(entrada, bancoAluno);
				break;

			default:
				System.out.println("Até mais!");
				break;
			}
			
		} while (opcao != 6);

	}
	
	public static int menu(Scanner entrada) {
		System.out.println("------ SISTEMA ACADÊMICO ------");
		System.out.println("1- Cadastrar aluno");
		System.out.println("2- Listar todos os aluno");
		System.out.println("3- Buscar por um aluno");
		System.out.println("4- Editar um aluno");
		System.out.println("5- Excluir um aluno");
		System.out.println("6- Sair");
		
		int opcao = entrada.nextInt();
		entrada.nextLine();
		return opcao;
	}
	
	public static void cadastrar(Scanner entrada, ArrayList<Aluno> bancoAluno) {
		System.out.println("----------------------------");
		System.out.println("Digite o nome do Aluno: ");
		String nome = entrada.nextLine();
		System.out.println("Digite a idade do Aluno: ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Digite o email do Aluno: ");
		String email = entrada.nextLine();
		

		if (nome != " " && idade >= 1 && email != " ") {
			Aluno aluno = new Aluno(nome, idade, email);
			bancoAluno.add(aluno);
			System.out.println("Aluno cadastrado com sucesso!");
		} else {
			System.out.println("Algo deu errado, confira se todos os dados estão preenchidos!");
		}
	}
	
	public static void listar(ArrayList<Aluno> bancoAluno) {
		int indice = 1;
		for (Aluno aluno : bancoAluno) {
			System.out.println("----------------------------");
			System.out.println(indice);
			indice++;
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Email: " + aluno.getEmail());
		}
	}
	
	public static void buscar(Scanner entrada, ArrayList<Aluno> bancoAluno) {
		System.out.print("Digite o nome do aluno: ");
		String nome = entrada.nextLine();
		
		if(nome != " ") {
			for (Aluno aluno : bancoAluno) {
				int indice = 1;
				if (aluno.getNome().toLowerCase().equals(nome.toLowerCase())) {
					System.out.println(indice);
					System.out.println("Nome: " + aluno.getNome());
					System.out.println("Idade: " + aluno.getIdade());
					System.out.println("Email: " + aluno.getEmail());
					System.out.println("----------------------------");
				}
				indice++;
			}
		}
	}
	
	public static void editar(Scanner entrada, ArrayList<Aluno> bancoAluno) {
		listar(bancoAluno);
		System.out.print("Digite o nome do aluno para editar: ");
		String nome = entrada.nextLine();
		
		if(nome != " ") {
			int indice = 1;
			for (Aluno aluno : bancoAluno) {
				if (aluno.getNome().toLowerCase().equals(nome.toLowerCase())) {
					System.out.println("Digite o novo nome do Aluno: ");
					String nomeNovo = entrada.nextLine();
					System.out.println("Digite a nova idade do Aluno: ");
					int idadeNova = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Digite o novo email do Aluno: ");
					String emailNovo = entrada.nextLine();
					System.out.println(indice);
					if (nomeNovo != " " && idadeNova >= 1 && emailNovo != " ") {
						aluno.setNome(nomeNovo);
						aluno.setIdade(idadeNova);
						aluno.setEmail(emailNovo);
						System.out.println("Aluno editado com sucesso!");
					}else {
						System.out.println("Algo deu errado, confira se todos os dados estão preenchidos!");
					}	
				}
				indice++;
			}
		}
	}
	
	public static void excluir(Scanner entrada, ArrayList<Aluno> bancoAluno) {
		listar(bancoAluno);
		System.out.print("Digite o nome do aluno que deseja deletar: ");
		String nome = entrada.nextLine();
		
		if(nome != " ") {
			int indice = 0;
			for (Aluno aluno : bancoAluno) {
				if (aluno.getNome().toLowerCase().equals(nome.toLowerCase())) {
					bancoAluno.remove(indice);
					break;
				}
				indice++;
			}
		}
	}
}
