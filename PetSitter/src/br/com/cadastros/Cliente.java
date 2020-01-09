package br.com.cadastros;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cliente implements Serializable {
	public Cliente(
		//	String raca, 	// Eu fiz isso com os parametros do contrutor
		//	String genero, 	// só pra eu conseguir visualizar melhor o parametros
		//	String idade, 	// É que a minha tela é piquena
			String nome, 	// mas o construtor da classe funciona do mesmo jeito
			String cpf, 	// fiquem tranquilas, eu só tirei tudo que tava numa linha só
			String endereco,// e quebrei em várias kkk
			String telefone
			)
	{
		// super(raca, genero, idade);
		/*
		 * Meninas, desculpem o tio kkk
		 * mas eu tive que tirar a herança que
		 * a classe estava fazendo na classe Pet.
		 * Faria mais sentido pra mim a classe Cliente ter
		 * uma 'lista de Pets' (List<Pets> pets)
		 * seria mais fácil de se fazer os cadastros e 
		 * organizar os relatórios. Fora que pra criar o objeto da classe
		 * Cliente ele pedia uma (new Cliente(...)) ele pedia uma renca
		 * de informação que no método cadastrar cliente não pediam, ou seja,
		 * faltavam (Eu explico melhor depois).
		 * Mas pra cadastrar o Pet junto com o cadastro do cliente, o Lucca
		 * facilitou as coisas chamando o método 'cadastrarPet()' dentro
		 * do método 'cadastrarCliente()'
		 * A classe assim deixou mais fácil de se cadastrar um cliente =D
		 * mas nao deixou o código consistente, mas a gente vai aprender isso
		 * nos próximos semestres
		 */
		this.nome = nome;
		this.cpf=cpf;
		this.endereco= endereco;
		this.telefone = telefone;
	}

	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	
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
