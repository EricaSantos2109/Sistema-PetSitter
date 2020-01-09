package br.com.cadastros;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pet implements Serializable {
	private String raca;
	private String nome;
	private String genero;
	private String idade;
	private int contMasc = 0; 	// criei essas variáveis para conseguir contabilizar
	private int contFem = 0; 	// o número de vezes em que o genero foi escolhido por raça
	
	public Pet(String raca, String genero, String idade, String nome){
		this.genero = genero;
		this.raca= raca;
		this.idade = idade;
		
		if (raca.trim().toUpperCase().equals("F")) {
			this.contFem += 1;
		}
		else {
			this.contMasc += 1;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public int getContMasc() {
		return contMasc;
	}

	public int getContFem() {
		return contFem;
	}
}