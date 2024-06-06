package dominio;

public class Cadastro {
	
	private String tipoUsuario;
	
	public Cadastro(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	// Getter e Setters
	public String getTipo() {
		return tipoUsuario;
	}
}
