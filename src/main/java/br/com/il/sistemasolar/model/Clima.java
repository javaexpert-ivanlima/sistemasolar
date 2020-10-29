package br.com.il.sistemasolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Entidade que mapeia o resultado do clima se no dia é previsto chuva,seca ou otimo.
 * Também traz o valor do perimetro apenas para o caso de chuva
 * @author Ivan lima
 *
 */
@Entity
public class Clima {
	
		@Id
		@Column(name = "ID")
		private Long dia;
		
		@NotNull
		@Column(name = "CLIMA")
		private String clima;
		
		@Column(name = "PERIMETRO")
		private double perimetro;
		
		public Clima() {
		}
		
		public Clima(Long dia,String clima) {
			this.setDia(dia);
			this.setClima(clima);
		}
	
		public Clima(Long dia,String clima,double perimetro) {
			this.setDia(dia);
			this.setClima(clima);
			this.setPerimetro(perimetro);
		}
		
		public Long getDia() {
			return dia;
		}
		public void setDia(Long dia) {
			this.dia = dia;
		}


		public String getClima() {
			return clima;
		}


		public void setClima(String clima) {
			this.clima = clima;
		}


		public double getPerimetro() {
			return perimetro;
		}


		public void setPerimetro(double perimetro) {
			this.perimetro = perimetro;
		}

		

}
