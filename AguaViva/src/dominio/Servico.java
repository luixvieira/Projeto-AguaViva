package dominio;

import java.time.LocalDate;

public class Servico {
	
	private String temaServico;
	private String descricaoServico;
	private LocalDate dataServico;
	private Praia localServico;
	private Hospedagem localTurismo;
	private Voluntario voluntarioResponsavel;
	
	public Servico(String temaServico, String descricaoServico, LocalDate dataServico, Praia localServico,
			Hospedagem localTurismo, Voluntario voluntarioResponsavel) {
		this.temaServico = temaServico;
		this.descricaoServico = descricaoServico;
		this.dataServico = dataServico;
		this.localServico = localServico;
		this.localTurismo = localTurismo;
		this.voluntarioResponsavel = voluntarioResponsavel;
	}

	// Getter e Setters
	public String getTemaServico() {
		return temaServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public LocalDate getDataServico() {
		return dataServico;
	}

	public Praia getLocalServico() {
		return localServico;
	}

	public Hospedagem getLocalTurismo() {
		return localTurismo;
	}
	
}
