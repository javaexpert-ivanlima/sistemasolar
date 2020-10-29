package br.com.il.sistemasolar.utils;

/**
 * Enum - Classe com o DOMINIO dos tipos de clima possiveis
 * @author Enum
 *
 */
public enum ClimaEnum {
	
		SECA("SECA"),
		CHUVA("CHUVA"),
		OTIMO("OTIMO"),
		INDEFINIDO("INDEFINIDO");
	
		private String descricao;
		
		ClimaEnum(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
	
}
