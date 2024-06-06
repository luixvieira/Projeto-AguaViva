package prototipo_de_infra;

import java.util.ArrayList;

import dominio.Cadastro;
import dominio.Contato;
import dominio.Endereco;
import dominio.Hospedagem;
import dominio.Login;
import dominio.Servico;
import dominio.Voluntario;

public class BaseVoluntarios {
	
	private int numeroDaBase;
	
	public BaseVoluntarios(int numeroDaBase) {
		this.numeroDaBase = numeroDaBase;
	}
	
// Voluntário 1
	// Endereço
	Endereco enderecoVoluntario00 = new Endereco("Rua das Capivaras", 69, "65871233", "São Paulo/SP");
	
	// Lista de contatos
	ArrayList<Contato> contatosVoluntario00 = new ArrayList<>();
	Contato contato1Voluntario00 = new Contato("9543754342");
	
	// Criando cadastro
	Cadastro cadastroVoluntario00 = new Cadastro("Voluntário");
	
	// Criando login
	Login loginVoluntario00 = new Login("luis@email.com", "123456");
	
	// Criando lista dos serviços do voluntário
	ArrayList<Servico> servicosVoluntario00 = new ArrayList<>();
	
	Voluntario voluntario00 = new Voluntario("Luis", "Henrique Vieira", "73724372394", enderecoVoluntario00, contatosVoluntario00, 
			cadastroVoluntario00, loginVoluntario00, 18, servicosVoluntario00);
	
// Voluntário 2
	// Endereço
	Endereco enderecoVoluntario01 = new Endereco("Av. Municipal", 249, "40483342", "Mairiporã/SP");
	
	// Lista de contatos
	ArrayList<Contato> contatosVoluntario01 = new ArrayList<>();
	Contato contato1Voluntario01 = new Contato("9543754342");
	
	// Criando cadastro
	Cadastro cadastroVoluntario01 = new Cadastro("Voluntário");
	
	// Criando login
	Login loginVoluntario01 = new Login("roberto@email.com", "123456");
	
	// Criando lista dos serviços do voluntário
	ArrayList<Servico> servicosVoluntario01 = new ArrayList<>();
	
	Voluntario voluntario01 = new Voluntario("Roberto", "Silva Pereira", "9239273239", enderecoVoluntario01, contatosVoluntario01, 
			cadastroVoluntario01, loginVoluntario01, 19, servicosVoluntario01);
	
	private void adicionarContatos() {
		contatosVoluntario00.add(contato1Voluntario00);
		contatosVoluntario01.add(contato1Voluntario01);
	}
	
	public void estanciarDados(ArrayList<Voluntario> voluntarios) {
		adicionarContatos();
		voluntarios.add(voluntario00);
		voluntarios.add(voluntario01);
	}

}
