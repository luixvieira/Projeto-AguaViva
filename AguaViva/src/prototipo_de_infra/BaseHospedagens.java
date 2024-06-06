package prototipo_de_infra;

import java.util.ArrayList;

import dominio.Contato;
import dominio.Endereco;
import dominio.Hospedagem;

public class BaseHospedagens {

	private int numeroDaBase;

	public BaseHospedagens(int numeroDaBase) {
		this.numeroDaBase = numeroDaBase;
	}

// Hospedagem Local Feliz
	// Endereço
	Endereco enderecoLocalFeliz = new Endereco("Rua Feliz", 45, "09272363", "Santos/SP");
	
	 // Lista de contatos
	ArrayList<Contato> contatosLocalFeliz = new ArrayList<>();
	Contato contato1LocalFeliz = new Contato("1197243746", "1174746823");
	
	Hospedagem localFeliz = new Hospedagem(1, "Pousada Local Feliz", "1234354678564432", enderecoLocalFeliz, contatosLocalFeliz, "Pousada", 2);


// Hospedagem Bem Legal
	// Endereço
	Endereco enderecoBemLegal = new Endereco("Rua das Palmeiras", 57, "04984823", "Ubatuba/SP");
	
	// Lista de contatos
	ArrayList<Contato> contatosBemLegal = new ArrayList<>();
	Contato contato1BemLegal = new Contato("1197243746", "1174746823");
	
	Hospedagem bemLegal = new Hospedagem(2, "Bem Legal", null, enderecoBemLegal, contatosBemLegal, "Hotel", 0);


	private void adicionarContatos() {
		contatosLocalFeliz.add(contato1LocalFeliz);
		contatosBemLegal.add(contato1BemLegal);
	}

	public void estanciarDados(ArrayList<Hospedagem> hospedagens) {
		adicionarContatos();
		hospedagens.add(localFeliz);
		hospedagens.add(bemLegal);
	}

	public Hospedagem getHospedagem(ArrayList<Hospedagem> hospedagens, int opcao) {
		Hospedagem hospedagemEscolhida = hospedagens.get(opcao - 1);
		return hospedagemEscolhida;
	}

}
