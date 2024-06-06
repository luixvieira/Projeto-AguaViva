package dominio;

public class Contato {
	
	private String telefoneCelular;
	private String telefoneFixo;
	
	// Contato completo
	public Contato(String telefoneCelular, String telefoneFixo) {
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
	}

	// Contato sem telefone fixo
	public Contato(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
}
