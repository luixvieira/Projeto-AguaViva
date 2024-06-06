package prototipo_de_infra;

import java.util.ArrayList;

import dominio.Administrador;
import dominio.Cadastro;
import dominio.Contato;
import dominio.Endereco;
import dominio.Login;

public class BaseAdministradores {

	private int numeroDaBase;

	public BaseAdministradores(int numeroDaBase) {
		this.numeroDaBase = numeroDaBase;
	}

// Administrador 1
	// Endereço
	Endereco enderecoAdm00 = new Endereco("Rua das Flores", 25, "064895220", "São Paulo/SP"); 
	
	// Lista de contatos
	ArrayList<Contato> contatosAdm00 = new ArrayList<>();
	Contato contato1Adm00 = new Contato("11934565483"); // Contato 1, apenas celular
	Contato contato2Adm00 = new Contato("11972364247", "114939370"); // Contato 2, celular e telefone fixo
	
	// Criando cadastro
	Cadastro cadastroAdm00 = new Cadastro("Administrador");
	
	// Criando login
	Login loginAdm00 = new Login("adm1@email.com", "123456");
	
	Administrador adm00 = new Administrador("Carlos", "Fontes Silva", "12345678909", enderecoAdm00, contatosAdm00, cadastroAdm00, loginAdm00);

	private void adicionarContatos() {
		contatosAdm00.add(contato1Adm00);
		contatosAdm00.add(contato2Adm00);
	}

	public void estanciarDados(ArrayList<Administrador> administradores) {
		adicionarContatos();
		administradores.add(adm00);
	}

	public Administrador getAdministrador(ArrayList<Administrador> administradores, int opcao) {
		Administrador administradorEscolhido = administradores.get(opcao - 1);
		return administradorEscolhido;
	}
}
