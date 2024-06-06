package dominio;

import java.util.ArrayList;

public class Administrador extends Usuario implements UsuarioInterno {

	public Administrador(String nomeUsuario, String sobrenomeUsuario, String cpfUsuario,
			Endereco endereco, ArrayList<Contato> contatos, Cadastro cadastro, Login login) {
		super(nomeUsuario, sobrenomeUsuario, cpfUsuario, endereco, contatos, cadastro, login);
	}

	@Override
	public void verificarHospedagens(ArrayList<Hospedagem> hospedagens) {
		for (Hospedagem hospedagem : hospedagens) {
			if (hospedagem.getCnpj() == null) {
				throw new UnsupportedOperationException("Hospedagem " + hospedagem.getNome() 
				+ " não qualificada para ser utilizada.");
			}	
		}
	}

	@Override
	public void cancelarHospedagem(Hospedagem hospedagem) {
		hospedagem.setStatus("Cancelada");
	}

	@Override
	public void cancelarVoluntariado(Voluntario voluntario) {
		voluntario.setStatus("Cancelado");
	}

}
