package main;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.Administrador;
import dominio.Hospedagem;
import dominio.Login;
import dominio.Voluntario;
import prototipo_de_infra.BaseAdministradores;
import prototipo_de_infra.BaseHospedagens;
import prototipo_de_infra.BaseVoluntarios;

public class MainAdministradores {

	public static void main(String[] args) {

		// Hospedagens
		ArrayList<Hospedagem> hospedagens = new ArrayList<>();
		BaseHospedagens baseHospedagens = new BaseHospedagens(1);
		baseHospedagens.estanciarDados(hospedagens);

		// Voluntários
		ArrayList<Voluntario> voluntarios = new ArrayList<>();
		BaseVoluntarios baseVoluntarios = new BaseVoluntarios(1);
		baseVoluntarios.estanciarDados(voluntarios);
		
		// Administradores
		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		BaseAdministradores baseAdministradores = new BaseAdministradores(1);
		baseAdministradores.estanciarDados(administradores);
		Administrador adm00 = baseAdministradores.getAdministrador(administradores, 1);
		
// ####################################################################################################################################################

		// Iniciando menu de exibição
		Scanner leitor = new Scanner(System.in);
		
		// Cria um login temporário para uso do sistema para o administrador
		Login loginAdm = adm00.getLogin();

		System.out.println("====== AGUAVIVA - ADM ======");
		System.out.println("\n           |LOGIN|\n");

		String login, senha;
		System.out.print("Digite seu login: ");
		login = leitor.nextLine();

		System.out.print("Digite sua senha: ");
		senha = leitor.nextLine();
		
		// Inicia a interface dos administradores. Com try/catch para tratar os possíveis erros
		try {
			// verifica se o login e senha estão corretos
			loginAdm.validarLogin(login, senha);
			
			// Exibe a interface
			System.out.println("\nSeja bem-vindo(a) " + adm00.getNome() + "!");
			while (true) {
				System.out.println("\n====== AGUAVIVA - ADM ======");
				System.out.println("1-) Verificar Hospedagens");
				System.out.println("2-) Cancelar Hospedagens");
				System.out.println("3-) Cancelar Voluntários");
				System.out.println("4-) Exibir Hospedagens");
				System.out.println("5-) Sair");
				System.out.println("=============================");

				System.out.print("\nDigite uma opção: ");
				int opcao = leitor.nextInt(); leitor.nextLine();

				if (opcao == 1) {
					
					// Verifica se as hospedagens são válidas
					adm00.verificarHospedagens(hospedagens);
					System.out.println("\nTodas as hospedagens são válidas para uso.");
				
				} else if (opcao == 2) {
					
					// Lógica para cancelar uma hospedagem
					System.out.println("\n|Hospedagens cadastradas|");
					int indexListaHospedagem = 1; 
					for (Hospedagem hospedagem : hospedagens) {
						System.out.println("\nHospedagem " + indexListaHospedagem);
						System.out.println("Nome: " + hospedagem.getNome());
						System.out.println("CNPJ: " + hospedagem.getCnpj());
						indexListaHospedagem++;
					}
					System.out.print("\nDigite o número do ID correspondente à hospedagem que deseja cancelar: ");
					int opcaoCancelamento = leitor.nextInt(); leitor.nextLine();
					Hospedagem hospedagemEscolhida = hospedagens.get(opcaoCancelamento - 1);
					adm00.cancelarHospedagem(hospedagemEscolhida);
					hospedagens.remove(opcaoCancelamento - 1);
					
					System.out.println("\nHospedagem " + hospedagemEscolhida.getNome() + " cancelada com sucesso!");

				} else if (opcao == 3) {
					
					// Lógica para cancelar um voluntário
					System.out.println("\n|Voluntários cadastrados|");
					int indexListaVoluntarios = 1;
					for (Voluntario v : voluntarios) {
						System.out.println("\nVoluntário " + indexListaVoluntarios);
						System.out.println("Nome: " + v.getNome());
						indexListaVoluntarios++;
					}
					System.out.print("\nDigite o número correspondente ao voluntário que deseja cancelar: ");
					int opcaoCancelamento = leitor.nextInt(); leitor.nextLine();
					Voluntario voluntarioEscolhido = voluntarios.get(opcaoCancelamento - 1);
					adm00.cancelarVoluntariado(voluntarioEscolhido);
					voluntarios.remove(opcaoCancelamento - 1);

					System.out.println("\nVoluntário cancelado com sucesso!");
				
				} else if (opcao == 4) {
					
					// Exibir as hospedagens cadastradas
					System.out.println("\n|Hospedagens cadastradas|");
					int indexListaHospedagem = 1; 
					for (Hospedagem hospedagem : hospedagens) {
						System.out.println("\nHospedagem " + indexListaHospedagem);
						System.out.println("Nome: " + hospedagem.getNome());
						System.out.println("CNPJ: " + hospedagem.getCnpj());
						System.out.println("Status: " + hospedagem.getStatus());
						indexListaHospedagem++;
					}
					
				} else if (opcao == 5) {
					System.out.println("\nSaindo do sistema...");
					break;
					
				// Caso o voluntário selecione uma opção que não tem no menu
				} else {
					System.out.println("\nOpção inválida! Digite uma opção válida.");
				}
			}	
			
		// Exibe as possíveis exceções tratadas do sistema
		} catch (IllegalArgumentException | UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		

		leitor.close();
	}

}
