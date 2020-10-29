package br.com.il.sistemasolar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe responsavel por maperar a posicao do planeta no eixo x e y, posicao em graus,radianos etc
 * @author Ivan Lima
 *
 */
@Entity
public class PosicaoPlaneta {
		@Id
		@GeneratedValue		
		private Long id;
		@OneToOne
		private Planeta planeta;
		@OneToOne
		private Ponto posicao;
		@OneToOne
		private Clima clima;
		
		public PosicaoPlaneta() {
		}

		public PosicaoPlaneta(Planeta planeta,Ponto posicao,Clima clima) {
				this.setPlaneta(planeta);
				this.setPosicao(posicao);
				this.setClima(clima);
		}

		public Planeta getPlaneta() {
			return planeta;
		}

		public void setPlaneta(Planeta planeta) {
			this.planeta = planeta;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Ponto getPosicao() {
			return posicao;
		}

		public void setPosicao(Ponto posicao) {
			this.posicao = posicao;
		}

		public Clima getClima() {
			return clima;
		}

		public void setClima(Clima clima) {
			this.clima = clima;
		}

		
}
