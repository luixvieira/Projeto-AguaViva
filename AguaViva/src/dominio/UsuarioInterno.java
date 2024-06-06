package dominio;

import java.util.ArrayList;

public interface UsuarioInterno {
	
	public void verificarHospedagens(ArrayList<Hospedagem> hospedagens);
	public void cancelarHospedagem(Hospedagem hospedagem);
	public void cancelarVoluntariado(Voluntario voluntario);
}
