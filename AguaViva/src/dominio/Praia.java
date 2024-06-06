package dominio;

import java.util.ArrayList;

public class Praia {
	
	private String nomePraia;
	private Endereco endereco;
	private ArrayList<Hospedagem> hospedagens;
	
	public Praia(String nomePraia, Endereco endereco, ArrayList<Hospedagem> hospedagens) {
		this.nomePraia = nomePraia;
		this.endereco = endereco;
		this.hospedagens = hospedagens;
	}

	// Getter e Setters
	public ArrayList<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public String getNome() {
		return nomePraia;
	}

	public String getEndereco() {
		String endereco = this.endereco.getEndereco();
		return endereco;
	}
	
}
