package dominio;

import java.util.ArrayList;

public class Hospedagem {
	
	private int idHospedagem;
	private String nomeHospedagem;
	private String cnpjHospedagem;
	private Endereco endereco;
	private ArrayList<Contato> contatos;
	private String tipoHospedagem;
	private int vagasDisponiveis;
	private String status = null;
	
	public Hospedagem(int idHospedagem, String nomeHospedagem, String cnpjHospedagem, Endereco endereco,
			ArrayList<Contato> contatos, String tipoHospedagem, int vagasDisponiveis) {
		this.idHospedagem = idHospedagem;
		this.nomeHospedagem = nomeHospedagem;
		this.cnpjHospedagem = cnpjHospedagem;
		this.endereco = endereco;
		this.contatos = contatos;
		this.tipoHospedagem = tipoHospedagem;
		this.vagasDisponiveis = vagasDisponiveis;
	}
	
	public String reservarHospedagem(Voluntario voluntarios) {
		String status = this.status;
		
		if (vagasDisponiveis >= 1) {
			status = "Ativa";
			
		} else {
			throw new UnsupportedOperationException("\nNão foi possível efetuar reserva: Vagas insuficientes.");
		}
		return status;
	}

	// Getter e Setters
	public String getCnpj() {
		return cnpjHospedagem;
	}
	
	public String setStatus(String novoStatus) {
		status = novoStatus;
		return status;
	}

	public String getNome() {
		return nomeHospedagem;
	}

	public String getStatus() {
		String status = this.status;
		
		if (status == null) {
			status = "Sem hospedagens cadastradas.";
		}
		
		return status;
	}
	
}
