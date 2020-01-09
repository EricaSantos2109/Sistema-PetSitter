package br.com.cadastros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.atendimentos.HistoricoAtendimento;
import br.com.atendimentos.Menu;

@SuppressWarnings("serial")
public class Acoes implements Serializable {
	public List<PetSitter> petSitters = new ArrayList<PetSitter>();
	public List<Pet> pets = new ArrayList<Pet>();
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<HistoricoAtendimento> atendimentos = new ArrayList<HistoricoAtendimento>();
	transient Controle controle;
	transient Menu menu = new Menu();

	public void listarPetSitter() {
		if (petSitters.size() == 0) {
			System.out.println("Lista de PetSitters vazia!\n");
		} else {
			System.out.println("PetSitters Cadastrados");
			for (PetSitter c : petSitters) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("Endere�o: " + c.getEndereco());
				System.out.println("CPF: " + c.getCpf() + "\n");

			}
		}
	}

	public void listarPet() {
		if (pets.size() == 0) {
			System.out.println("Lista de Pet vazia!\n");
		} else {
			System.out.println("Pets Cadastrados");
			for (Pet c : pets) {
				System.out.println("raca: " + c.getRaca());
				System.out.println("G�nero: " + c.getGenero());
				System.out.println("Idade: " + c.getIdade() + "\n");
			}
		}
	}

	public void cadastrarPetSitter(Scanner scanner) {
		String nome, telefone, endereco, cpf;
		
		System.out.print("\nInsira o nome: ");
		scanner.nextLine(); // Adianta o leitor p/ realizar a prox. leitura.
		nome = scanner.nextLine(); // nextLine() lê strings com espaços.

		System.out.print("\nInsira o telefone: ");
		telefone = scanner.next();

		System.out.print("\nInsira o endereco: ");
		scanner.nextLine();
		endereco = scanner.nextLine();

		System.out.print("\nInsira o CPF: ");
		cpf = scanner.next();

		PetSitter novoPetSitter = new PetSitter(nome, telefone, endereco, cpf);

		petSitters.add(novoPetSitter);

		System.out.println("\nCadastro do PetSitter realizado com sucesso!");
	}

	public void cadastrarCliente(Scanner scanner) {
		String nome, telefone, endereco, cpf;

		System.out.print("\nInsira o nome: ");
		scanner.nextLine(); // Adianta o leitor p/ realizar a prox. leitura.
		nome = scanner.nextLine(); // nextLine() lê strings com espaços.
		
		System.out.print("\nInsira o telefone: ");
		telefone = scanner.next();
		
		System.out.print("\nInsira o endereco: ");
		scanner.nextLine();
		endereco = scanner.nextLine();
		
		System.out.print("\nInsira o CPF: ");
		cpf = scanner.next();
		
		Cliente novoCliente = new Cliente(nome, cpf, endereco, telefone);
		clientes.add(novoCliente);
		
		System.out.println("\nCadastro do cliente realizado com sucesso!");
		
		int opPet;
		System.out.println("Quantos animais voce deseja cadastrar?? Limite at� 5 animais!!");
		opPet = scanner.nextInt();
		while(opPet > 5) {
			System.out.println("Voc� n�o pode cadastrar mais que 5 animais\n");
			System.out.println("Quantos animais voce deseja cadastrar?? Limite at� 5 animais!!");
			opPet = scanner.nextInt();
		}
		for(int i = 0; i<opPet; i++) {
			cadastrarPet(scanner);
		}
		
}

	public void cadastrarPet(Scanner scanner) {

		System.out.println("Iniciando cadastro do PET...");
		String raca, idade, genero, apelido;
		
		System.out.println("Entre com o nome/apelido do animal:");
		apelido = scanner.next();
		System.out.println("Entre com a raca do animal:");
		scanner.nextLine();
		raca = scanner.nextLine();
		System.out.println("Entre com a idade do animal:");
		idade = scanner.next();
		System.out.println("Entre com o genero do animal: (M/F)");
		genero = scanner.next();

		Pet novoPet = new Pet(raca, genero, idade, apelido);
		if (pets.size() <= 5) {
			pets.add(novoPet);
			System.out.println("\nCadastro do animal realizado com sucesso!");
		} else {
			System.out.println("N�O PODE MAN�");
		}

	}

	public void atendimento() {
		Scanner scaninho = new Scanner(System.in);
		System.out.println("Escolha o PetSitter:\n");
		int opt = 0;
		///// ------------------------------------------
		for (int i = 0; i < petSitters.size(); i++) {
			System.out.println((i + 1) + " - " + petSitters.get(i).getNome());
		}

		opt = scaninho.nextInt();

		PetSitter pst = petSitters.get(opt - 1);

		// ---------------------------
		scaninho.nextLine();
		opt = 0;
		System.out.println("Escolha o Cliente:\n");
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println((i + 1) + " - " + clientes.get(i).getNome());
		}

		opt = scaninho.nextInt();

		Cliente clt = clientes.get(opt - 1);
		
		/*
		 * Eu criei chance do usuário pode adicionar 
		 * mais de um animal
		 * e por isso eu criei até um limitador de 5 animais
		 * por atendimento.
		 * Por isso, achei melhor alterar a classe HistoricoAtendimento
		 * para receber uma lista de atendimento
		 * assim fica mais tranquilo de se colocar no relatório de 
		 * histórico de atendimento os detalhes de 
		 * cada animal escolhido em determinado atendimento
		 */
		
		List<Pet> miniListaPets = new ArrayList<Pet>();
		while(true) {
			if(miniListaPets.size() <= 5) {
				scaninho.nextLine();
				opt = 0;
				System.out.println("Escolha o Pet:\n");
				for (int i = 0; i < pets.size(); i++) {
					System.out.println((i + 1) + " - " + pets.get(i).getNome());
				}

				opt = scaninho.nextInt();

				Pet pet = pets.get(opt - 1);
				
				miniListaPets.add(pet);
				scaninho.nextLine();
				
				System.out.println("Deseja escolher mais algum animal? (S/N)");
				String s = scaninho.nextLine();
				if(s.trim().toUpperCase().equals("N")) {
					break;
				}
				
			} else {
				System.out.println("Já foram escolhidos 5 animais!");
				break;
			}
		}
		HistoricoAtendimento ha = new HistoricoAtendimento(pst, clt, miniListaPets);
		atendimentos.add(ha);

	}

	public void historicoAtendimento(Scanner scanner) {
		System.out.println("Histórico de todos os atendimentos ralizados: \n");
		
		for (HistoricoAtendimento historicoAtendimento : atendimentos) {
			System.out.println("Cliente: " + historicoAtendimento.getCliente());
			System.out.println("PetSitter: " + historicoAtendimento.getPst());
			
			for (Pet pet : historicoAtendimento.getPets()) {
				System.out.println("    Pets: ");
				System.out.println("    " + pet.getNome());
				System.out.println("    " + pet.getGenero());
				System.out.println("    " + pet.getIdade());
				System.out.println("    " + pet.getRaca());
			}
		}
	}

	public void racasComuns() {
		Set<String> rcs = new HashSet<String>();
		
		Map<String, Integer> rank = new HashMap<String, Integer>();

		for (Pet pt : pets) {
			rcs.add(pt.getRaca().trim().toUpperCase());
		}
		
		for (String r : rcs) {
			rank.put(r, 0);
		}
		
		for (String r : rcs) {
			for (Pet pt : pets) {
				if(r.equals(pt.getRaca().trim().toUpperCase())) {
					Integer quantidade = rank.get(r);
					quantidade++;
					rank.put(r, quantidade);
				}
			}	
		}
		
		/*
		 * Aqui embaixo eu usei esse código q eu encontrei na net pra ordenar o raking
		 * como o Map eh uma lista q possui 'chave' e 'valor', então eu precisei criar 
		 * uma lista do tipo Map ordenada (rankOrdenado) e depois imprimir cada um dos valores
		 * usando o for ali embaixo pra exibir o valor de cada item da lista
		 */
		
		Map<String, Integer> rankOrdenado = rank.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		//rankOrdenado.forEach((chave, valor) -> System.out.println(chave + " - " + valor));
		
		for (int i = rankOrdenado.size(); i-1 >= 0; i--) { 
			/*
			 * Fiz o loop do for rodar de trás para frente
			 * para o sistema mostrar o ranking do maior para o menor 
			 */
			int count = 0;
			if (count <= 10) {
				System.out.println(i + " - " + rankOrdenado.get(String.valueOf(i)));
			}
			count++;
		}
	}

	public void RacaPorGenero(Scanner scanner) {
		Set<String> rcs = new HashSet<String>();
		
		for (Pet pt : pets) {
			rcs.add(pt.getRaca().trim().toUpperCase());
		}		
		scanner.nextLine();
		String raca;
		
		for (String r : rcs) {
			System.out.println(r + "\n");
		}
		
		System.out.println("Escolha a raca:");
		raca = scanner.nextLine();
		// 
		for (Pet p : pets) {
			if (p.getRaca().toUpperCase().equals(raca.trim().toUpperCase())) {
				int masc = p.getContMasc(); // Aqui eu atribuí os valores do número de cadastros
				int fem = p.getContFem();	// de cada gênero para poder fazer a comparação
											// mais fácil.
				/*
				 *  getContMasc e getContFem são getters que
				 *  eu criei pra conseguir contabilizar cada gênero
				 *  em cada cadastro de pet
				 */
				if (masc > fem) {
					System.out.println("Masculino foi o gênero mais escolhido para esta raça: \n" + masc
							+ " cadastros.");
				} else {
					System.out.println("Feminino foi o gênero mais escolhido para esta raça: \n" + fem
							+ " cadastros.");
				}
			}
		}
	}

	public void relatorios(Scanner scanner) {
		menu.imprimirMenuRelatorios();

		int opRelatorio;
		System.out.println("\nEscolha a op��o desejada:\n ");
		opRelatorio = scanner.nextInt();

		if (opRelatorio == 1) {
			racasComuns();
		} else if (opRelatorio == 2) {
			RacaPorGenero(scanner);

		} else {
			menu.imprimirMenu();
		}

	}

	public static Acoes carregar() throws Exception {
		FileInputStream entrada = new FileInputStream("bdpetsitter.txt");
		ObjectInputStream leitor = new ObjectInputStream(entrada);
		Object obj = leitor.readObject();
		Acoes acoes = (Acoes) obj;
		leitor.close();
		return acoes;
	}

	public static void salvar(Acoes acoes) throws Exception {
		FileOutputStream saida = new FileOutputStream("bdpetsitter.txt");
		ObjectOutputStream escritor = new ObjectOutputStream(saida);
		escritor.writeObject(acoes);
		escritor.close();
	}

}
