package br.com.cadastros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Controle {
	public Scanner scanner;
	
	public Controle() {
		scanner = new Scanner(System.in);
	}
	
	public int lerOpcao() {
		int op = scanner.nextInt();
		return op;
	}
	
	public String escreverTexto() {
		String texto = scanner.next();
		return texto;
	}
	public Acoes carregar() throws Exception{
		FileInputStream entrada = new FileInputStream("acoes.txt");
		ObjectInputStream leitor = new ObjectInputStream(entrada);
		Object ob = leitor.readObject();
		Acoes ac = (Acoes) ob;
		leitor.close();
		
		return ac;
	}
	
	public void salvar(Acoes ac) throws Exception{
		FileOutputStream saida = new FileOutputStream("acoes.txt");
		ObjectOutputStream escritor = new ObjectOutputStream(saida);
		escritor.writeObject(ac);
		escritor.close();
		
	}
	
	@Override
	public void finalize() throws Throwable{
		scanner.close();
	}

	public String escreverTextoLongo() {
		String texto = scanner.nextLine();
		return texto;
	}
}
