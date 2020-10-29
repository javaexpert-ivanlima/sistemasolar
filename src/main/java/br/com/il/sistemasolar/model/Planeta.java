package br.com.il.sistemasolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 * Classe que mapeia os atributos de planeta como:
 * Nome,Distancia,Velocidade e Direcao
 * @author Ivan Lima
 *
 */
@Entity
public class Planeta {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Column(name = "NOME")
	private String nome;
	@NotNull
	@Column(name = "DISTANCIA")
	private Long distancia;
	@NotNull
	@Column(name = "VELOCIDADE")
	private Long velocidadeAngularPorDia;
	@NotNull
	@Column(name = "DIRECAO")
	private boolean isAntihorario = false;

	public Planeta() {
	}

	public Planeta(String name, Long distance, Long grauPerDay) {
		this.setNome(name);
		this.setDistancia(distance);
		this.setVelocidadeAngularPorDia(grauPerDay);
	}
	public Planeta(String name, Long distance, Long grauPerDay,boolean sentido) {
		this.setNome(name);
		this.setDistancia(distance);
		this.setVelocidadeAngularPorDia(grauPerDay);
		this.setAntihorario(sentido);
	}
	public boolean isAntihorario() {
		return isAntihorario;
	}

	public void setAntihorario(boolean isAntihorario) {
		this.isAntihorario = isAntihorario;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getDistancia() {
		return distancia;
	}

	public void setDistancia(Long distancia) {
		this.distancia = distancia;
	}

	public Long getVelocidadeAngularPorDia() {
		return velocidadeAngularPorDia;
	}

	public void setVelocidadeAngularPorDia(Long velocidadeAngularPorDia) {
		this.velocidadeAngularPorDia = velocidadeAngularPorDia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna a Posicao do planeta no eixo X e Y baseado no dia.
	 * @param dia - Dia para ser retornado a posicao do planeta
	 * @return @Ponto 
	 */
	public Ponto getPosicao(long dia) {
		double posicaoEmGraus = (dia * this.getVelocidadeAngularPorDia()) % 360;
		if (isAntihorario) {
			posicaoEmGraus = 360 - posicaoEmGraus;
		}
		double posicaoEmRadianos = Math.toRadians(posicaoEmGraus);

		double x = Math.cos(posicaoEmRadianos) * this.getDistancia();
		double y = Math.sin(posicaoEmRadianos) * this.getDistancia();
		
		if (posicaoEmGraus == 90 || posicaoEmGraus == 270 ) {
			x = 0;
		}else if (posicaoEmGraus == 180 ||  posicaoEmGraus == 360) {
			y= 0;
		}
		Ponto p = new Ponto(x, y);
		p.setPosicaoEmGraus(posicaoEmGraus);
		p.setPosicaoEmRadianos(posicaoEmRadianos);
		p.setDia(dia);
		p.setPlaneta(this);
		return p;
	}

}
