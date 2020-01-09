package br.com.atendimentos;

import java.io.Serializable;
import java.util.List;

import br.com.cadastros.Cliente;
import br.com.cadastros.Pet;
import br.com.cadastros.PetSitter;

@SuppressWarnings("serial")
public class HistoricoAtendimento implements Serializable {
	private PetSitter pst;
	private Cliente cliente;
	private List<Pet> pets;

	/*
	 * Eu alterei a classe para que ela recebesse mais de um
	 * Pet por atendimento. Isso deixa a o relatório de 
	 * histórico de atendimento mais detalhado
	 */
	
	public HistoricoAtendimento(PetSitter pst, Cliente cliente, List<Pet> pets) {
		this.pst = pst;
		this.cliente = cliente;
		this.pets = pets;
	}

	public PetSitter getPst() {
		return pst;
	}

	public void setPst(PetSitter pst) {
		this.pst = pst;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	
}
