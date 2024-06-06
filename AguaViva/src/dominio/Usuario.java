package dominio;

import java.util.ArrayList;

public abstract class Usuario {
	
	protected String nomeUsuario;
	protected String sobrenomeUsuario;
	private String cpfUsuario;
	private Endereco endereco;
	private ArrayList<Contato> contatos;
	private Cadastro cadastro;
	private Login login;
	
	public Usuario(String nomeUsuario, String sobrenomeUsuario, String cpfUsuario, Endereco endereco,
			ArrayList<Contato> contatos, Cadastro cadastro, Login login) {
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.endereco = endereco;
		this.contatos = contatos;
		this.cadastro = cadastro;
		this.login = login;
	}

	// Getter e Setters
	public String getNome() {
		return nomeUsuario;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public String getEmail() {
		return login.getLogin();
	}
}
