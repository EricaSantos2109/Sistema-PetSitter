package br.com.atendimentos;

import java.io.Serializable;
import java.util.Scanner;

import br.com.cadastros.Acoes;
import br.com.cadastros.Controle;

@SuppressWarnings("serial")
public class App implements Serializable{

	public static void main(String[] args) throws Exception{
		Menu menu = new Menu();
		Acoes acoes = new Acoes();
		Scanner scanner = new Scanner(System.in);
		Controle ctrl = new Controle();
	
		try {
			acoes = ctrl.carregar();
		}
		catch(Exception e) {
			acoes = new Acoes();
		}
		
		int opt = 1;
		
		while(opt != 0) {
			Controle c = new Controle();
			menu.imprimirMenu();
			opt = c.lerOpcao();
			
			switch(opt) {
				case 1:
					acoes.cadastrarPetSitter(scanner);
					break;
				case 2:
					acoes.cadastrarCliente(scanner);
					break;
				case 3:
					acoes.relatorios(scanner);
					break;
				case 4:
					acoes.atendimento();
					break;
				case 5:
					acoes.historicoAtendimento(scanner);
					break;
				case 0:
					opt = 0;
					System.out.println("Programa Finalizado!!!");
					break;
				default:
					System.out.println("Informação nao identificada!");
					break;
			}
		}
		
		ctrl = new Controle();
		try {
			ctrl.salvar(acoes);
		}catch(Exception e) {
			System.out.println("O arquivo nao foi salvo!");
			e.printStackTrace();
		}
		
	}

}
