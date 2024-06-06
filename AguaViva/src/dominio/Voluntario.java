package dominio;

import java.util.ArrayList;

public class Voluntario extends Usuario {

	private int idade;
	private String status;
	private ArrayList<Servico> servicos;

	public Voluntario(String nomeUsuario, String sobrenomeUsuario, String cpfUsuario, Endereco endereco,
			ArrayList<Contato> contatos, Cadastro cadastro, Login login, int idade, ArrayList<Servico> servicos) {
		super(nomeUsuario, sobrenomeUsuario, cpfUsuario, endereco, contatos, cadastro, login);
		this.idade = idade;
		this.servicos = servicos;
		this.status = setStatus("Ativo");
		verificarMaioridade();
	}

	public void oferecerServico(Servico servico) {
		if (status == "Ativo") {
			servicos.add(servico);
		} else {
			throw new UnsupportedOperationException("\nNão foi possível oferecer um serviço: O voluntário está bloqueado ou foi excluído.");
		}
	}

	private boolean verificarMaioridade() {
		if (idade >= 18) {
			return true;
		} else {
			throw new UnsupportedOperationException("\nÉ preciso ter no mínimo 18 anos para poder voluntariar.");
		}
	}

	// Getter e Setters
	public String getStatus() {
		return status;
	}

	public String setStatus(String novoStatus) {
		status = novoStatus;
		return status;
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public String getNomeCompleto() {
		return nomeUsuario + " " + sobrenomeUsuario;
	}

}
