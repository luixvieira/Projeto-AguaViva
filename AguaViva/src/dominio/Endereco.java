package dominio;

public class Endereco {
	
	private String logradouro;
	private int numero;
	private String cep;
	private String cidade;
	
	public Endereco(String logradouro, int numero, String cep, String cidade) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
	}
	
	// Getter e Setters
	public String getEndereco() {
		String endereco = "CEP: " + cep + " - " + cidade;
		return endereco;
	}
	
}
