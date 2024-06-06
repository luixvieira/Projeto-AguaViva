package dominio;

public class Login {
	
	private String login;
	private String senha;
	
	public Login(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public boolean validarLogin(String loginParaConfirmar, String senhaParaConfirmar) {
		if (!loginParaConfirmar.equals(login) | !senhaParaConfirmar.equals(senha)) {
			throw new IllegalArgumentException("\nLogin e/ou senha inválidos");
		} 
		return true;
	}
	
	// Getter e Setters
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
}
