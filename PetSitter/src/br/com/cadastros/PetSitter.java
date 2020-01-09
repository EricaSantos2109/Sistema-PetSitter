package br.com.cadastros;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PetSitter implements Serializable {
	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	
	public PetSitter(String nome, String cpf, String telefone, String endereco){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	} 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
