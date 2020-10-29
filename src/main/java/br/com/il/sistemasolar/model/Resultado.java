package br.com.il.sistemasolar.model;

import java.io.Serializable;

/**
 * Classe que mapeia o resultado de qtos dias terão chuva, seca,otimo e indefinido.
 * @author Ivan Lima
 *
 */
public class Resultado implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8927920062519287943L;
	private String clima;
	private Long dias;
	
	public Resultado() {
	}
	public Resultado(String clima,Long dias) {
		this.clima = clima;
		this.dias = dias;
	}
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public Long getDias() {
		return dias;
	}

	public void setDias(Long dias) {
		this.dias = dias;
	}
	
}
