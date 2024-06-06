package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Endereco;
import dominio.Hospedagem;
import dominio.Login;
import dominio.Praia;
import dominio.Servico;
import dominio.Voluntario;
import prototipo_de_infra.BaseHospedagens;
import prototipo_de_infra.BaseVoluntarios;
import java.util.Random;

public class MainVoluntarios {

	public static void main(String[] args) {

		// Hospedagens
		ArrayList<Hospedagem> hospedagens = new ArrayList<>();
		BaseHospedagens baseHospedagens = new BaseHospedagens(1);
		baseHospedagens.estanciarDados(hospedagens);

		// Praias
		ArrayList<Praia> praias = new ArrayList<Praia>();
		// Praia Grande Santos
		Endereco enderecoPraiaGrandeSantos = new Endereco("Rua das Capivaras", 40, "09272363", "Santos/SP");
		ArrayList<Hospedagem> hospedagensPraiaGrandeSantos = new ArrayList<Hospedagem>();
		hospedagensPraiaGrandeSantos.add(baseHospedagens.getHospedagem(hospedagens, 1));
		Praia praiaGrandeSantos = new Praia("Praia Grande", enderecoPraiaGrandeSantos, hospedagensPraiaGrandeSantos);
		praias.add(praiaGrandeSantos);

		// Praia de Maranduba
		Endereco enderecoPraiaMaranduba = new Endereco("Av. Maranduba", 10, "828403284", "Ubatuba/SP");
		ArrayList<Hospedagem> hospedagensPraiaMaranduba = new ArrayList<Hospedagem>();
		hospedagensPraiaMaranduba.add(baseHospedagens.getHospedagem(hospedagens, 2));
		Praia praiaMaranduba = new Praia("Praia de Maranduba", enderecoPraiaMaranduba, hospedagensPraiaMaranduba);
		praias.add(praiaMaranduba);
		
		// Voluntários
		ArrayList<Voluntario> voluntarios = new ArrayList<>();
		BaseVoluntarios baseVoluntarios = new BaseVoluntarios(1);
		baseVoluntarios.estanciarDados(voluntarios);
		
// ####################################################################################################################################################

		// Iniciando menu de exibição
		Scanner leitor = new Scanner(System.in);

		System.out.println("====== AGUAVIVA - Voluntários ======");
		System.out.println("\n           |LOGIN|\n");

		String login, senha;
		System.out.print("Digite seu login: ");
		login = leitor.nextLine();

		System.out.print("Digite sua senha: ");
		senha = leitor.nextLine();
		
		// Variável para fazer a exibição do erro(linha 218)
		boolean entrou = false;
		
		// Lógica para identificar qual é o voluntário que está logando no sistema
		for (Voluntario voluntario : voluntarios) {
			if (voluntario.getEmail().equals(login)) {
				
				// Cria um login temporário para uso do sistema para o voluntário 
				Login loginVoluntario = voluntario.getLogin();
				
				// Inicia a lista de servicos do volutário
				ArrayList<Servico> servicosVoluntario = voluntario.getServicos();
				
				// Inicia a interface dos voluntários. Com try/catch para tratar os possíveis erros
				try {
					// verifica se o login e senha estão corretos
					loginVoluntario.validarLogin(login, senha);
					entrou = true;
					
					// Exibe a interface
					System.out.println("\nSeja bem-vindo(a) " + voluntario.getNome() + "!");
					while (true) {
						System.out.println("\n====== AGUAVIVA - Voluntários ======");
						System.out.println("1-) Oferecer algum serviço");
						System.out.println("2-) Exibir seus serviços");
						System.out.println("3-) Cancelar Serviços");
						System.out.println("4-) Sair");
						System.out.println("======================================");

						System.out.print("\nDigite uma opção: ");
						int opcao = leitor.nextInt(); leitor.nextLine();

						if (opcao == 1) {
							
							// Lógica para adicionar um novo serviço ao usuário
							String temaServico, descricaoServico;
							
							System.out.println("\n______________________________________________________________________________");
							System.out.println("\nVoçê pode realizar diversos tipos de atividades ecológicas em uma praia!");
							System.out.println("\n--------------------------------------");
							System.out.println("\nAqui estão alguns exemplos:");
							System.out.println("- Limpeza (Recolher resíduos, entulhos, etc);");
							System.out.println("- Reciclagem (Incentivar a reciclagem de alguma maneira, \nreciclar a limpeza feita manualmente, etc);");
							System.out.println("- Educação (Educar os turistas com relação ao turismo sustentável, \npromover a educação ecológica de alguma maneira, etc);");
							System.out.println("\n--------------------------------------");
							System.out.println("\nOBS: Você pode realizar outros temas, mas não esqueça de especificar direitinho o que será feito na descrição ;)");
							
							System.out.print("\nDigite o tema do serviço que irá executar: ");
							temaServico = leitor.nextLine();

							System.out.print("Descreva brevemente o serviço que será realizado: ");
							descricaoServico = leitor.nextLine();
							
					        System.out.print("Digite a data no formato DD/MM/AAAA: ");
					        String data = leitor.nextLine();

					        // Formatador de data
					        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					        // Converter string para LocalDate
					        LocalDate dataServico = LocalDate.parse(data, formatador);
							
					        // Exibe a lista de praias para o voluntário poder escolher uma
				        	System.out.println("\n|Praias Disponíveis|");
				        	int indexDaPraia = 1;
					        for (Praia praia : praias) {
					        	System.out.println("\nPraia " + indexDaPraia);
					        	System.out.println("Nome: " + praia.getNome());
					        	System.out.println("Endereço: " + praia.getEndereco());
					        	indexDaPraia++;
					        }
					        
							System.out.print("\nDigite o número correspondente a Praia que deseja fazer o turismo e o serviço: ");
							int localServico = leitor.nextInt(); leitor.nextLine();
							Praia praiaEscolhida = praias.get(localServico - 1);							
							
							// Seleciona uma hospedagem presente no local de maneira randômica e justa
							Random random = new Random();
							int indexAleatorio = random.nextInt(praiaEscolhida.getHospedagens().size());
							Hospedagem hospedagemAleatoria = praiaEscolhida.getHospedagens().get(indexAleatorio);
							
							// Reserva a hospedagem caso ela tenha vagas disponíveis
							hospedagemAleatoria.reservarHospedagem(voluntario);
							
							Servico servico = new Servico(temaServico, descricaoServico, dataServico, praiaEscolhida, hospedagemAleatoria, voluntario);
							
							// Verifica se este voluntário pode oferecer esse serviço
							voluntario.oferecerServico(servico);
							
							System.out.println("\nServiço adcionado com sucesso e hospedagem reservada!");
							
						} else if (opcao == 2) {
							
							// Lógica para exibir os serviços do voluntário
							if (!servicosVoluntario.isEmpty()) {
								System.out.println("\n|Serviços Agendados|");
								int indexListaServicos = 1; 
								for (Servico s : servicosVoluntario) {
									System.out.println("\nServico " + indexListaServicos);
									System.out.println("Tema: " + s.getTemaServico());
									System.out.println("Descrição: " + s.getDescricaoServico());
									System.out.println("Data do serviço: " + s.getDataServico());
									System.out.println("Realizado na praia: " + s.getLocalServico().getNome());
									System.out.println("Responsável pelo serviço: " + voluntario.getNomeCompleto());
									System.out.println("O responsável ficará hospedado no(a): " + s.getLocalTurismo().getNome());
									indexListaServicos++;
								}
							} else {
								System.out.println("\nNenhum serviço foi atribuido à você no momento.");
							}
							
						} else if (opcao == 3) {
							
							// Lógica para cancelar um serviço do voluntário
							if (!servicosVoluntario.isEmpty()) {
								
								// Exibe a lista de serviços desponíveis para o voluntário poder escolher 1
								System.out.println("\n|Serviços Agendados|");
								int indexListaServicos = 1; 
								for (Servico s : servicosVoluntario) {
									System.out.println("\nServico " + indexListaServicos);
									System.out.println("Tema: " + s.getTemaServico());
									System.out.println("Descrição: " + s.getDescricaoServico());
									System.out.println("Data do serviço: " + s.getDataServico());
									System.out.println("Realizado na praia: " + s.getLocalServico());
									indexListaServicos++;
								}
								
								System.out.print("\nDigite o número correspondente ao serviço que deseja cancelar: ");
								int opcaoServico = leitor.nextInt(); leitor.nextLine();
								Servico servicoEscolhido = servicosVoluntario.get(opcaoServico - 1);
								servicosVoluntario.remove(servicoEscolhido);
								
								System.out.println("Serviço cancelado com sucesso!");
								
							} else {
								System.out.println("\nNenhum serviço foi atribuido à você no momento.");
							}
							
						} else if (opcao == 4) {
							System.out.println("\nSaindo do sistema...");
							break;
						
						// Caso o voluntário selecione uma opção que não tem no menu
						} else {
							System.out.println("\nOpção inválida! Digite uma opção válida.");
						}
					}	
					
				// Exibe as possíveis exceções tratadas do sistema
				} catch (IllegalArgumentException | UnsupportedOperationException e) {
					System.out.println("Erro: " + e.getMessage() + "\nPor favor, verifique a entrada e tente novamente.");
					entrou = true;
				}		

				leitor.close();
			}
		}
		
		// Caso não encontre nenhum login inserido pelo usuário
		if (entrou == false) {
			System.out.println("\nVoluntário não cadastrado no sistema.");
		}
		
	}
}
