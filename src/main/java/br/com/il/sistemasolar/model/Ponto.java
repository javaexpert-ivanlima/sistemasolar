package br.com.il.sistemasolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Classe responsavel por mapear a posicao de um planeta
 * As cordenadas sao de acordo com o eixo X e Y.
 * São calculados a partir do angulo e distancia do sol.
 * @author Ivan Lima
 *
 */
@Entity
public class Ponto {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "DIA")
	private Long dia;
	@NotNull
	@Column(name = "POSICAO_GRAU")	
	private Double posicaoEmGraus;
	@NotNull
	@Column(name = "VALOR_RADIANO")
	private Double posicaoEmRadianos;
	@NotNull
	@Column(name = "EIXO_X")
	private Double x;
	@NotNull
	@Column(name = "EIXO_Y")
	private Double y;
	@OneToOne
	private Planeta planeta;

	public Ponto() {
	}

	public Ponto(Double x, Double y) {
		this.setX(x);
		this.setY(y);
	}
	/**
	 * Retorna a distancia de um ponto
	 * @param ponto - ponto a ser verificado
	 * @return @Double (Distancia)
	 */
	public double getDistancia(Ponto ponto) {
			return Math.sqrt(Math.pow(ponto.getX()-this.getX(), 2))+Math.pow(ponto.getY()-this.getY(), 2);
		}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coordenas do ponto[x=");
		sb.append(this.getX());
		sb.append(", y=");
		sb.append(this.getY());
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Verifica se 3 pontos são lineares, ou seja, formam uma reta
	 * Utilizando matriz determinante
	 * @param c1 - Ponto 1
	 * @param c2 - Ponto 2
	 * @param c3 - Ponto 3
	 * @return
	 */
	public static boolean isLinear(Ponto c1, Ponto c2, Ponto c3	) {
		double d1 = (c2.getX() - c1.getX())/(c2.getY() - c1.getY());
		double d2 = (c3.getX() - c1.getX())/(c3.getY() - c1.getY());

		return (d2 == d1);
	}	
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Long getDia() {
		return dia;
	}

	public void setDia(Long dia) {
		this.dia = dia;
	}

	public Double getPosicaoEmGraus() {
		return posicaoEmGraus;
	}

	public void setPosicaoEmGraus(Double posicaoEmGraus) {
		this.posicaoEmGraus = posicaoEmGraus;
	}

	public Double getPosicaoEmRadianos() {
		return posicaoEmRadianos;
	}

	public void setPosicaoEmRadianos(Double posicaoEmRadianos) {
		this.posicaoEmRadianos = posicaoEmRadianos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

}
