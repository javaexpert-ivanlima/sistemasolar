package br.com.il.sistemasolar.utils;

import br.com.il.sistemasolar.model.Ponto;

/**
 * Classe responsavel por verificar operações com um triangulo
 * Por exemplo: Area,Perimetro, Distancia e se um ponto esta dentro do triangulo.
 * @author Ivan Lima
 *
 */
public class Triangulo {

	private Ponto ponto1;
	private Ponto ponto2;
	private Ponto ponto3;

	public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
		super();
		this.setPonto1(p1);
		this.setPonto2(p2);
		this.setPonto3(p3);
	}

	public Ponto getPonto1() {
		return ponto1;
	}

	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	public Ponto getPonto2() {
		return ponto2;
	}

	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}

	public Ponto getPonto3() {
		return ponto3;
	}

	public void setPonto3(Ponto ponto3) {
		this.ponto3 = ponto3;
	}

	/**
	 * Retorna a area do triangulo
	 * @return @float
	 */
	public float area() {
		return Math.abs((float) (ponto1.getX() * (ponto2.getY() - ponto3.getY())
				+ ponto2.getX() * (ponto3.getY() - ponto1.getY()) + ponto3.getX() * (ponto1.getY() - ponto2.getY()))
				/ 2);
	}

	/**
	 * Verifica se um ponto esta dentro da area do triangulo.
	 * @param ponto - Ponto a ser pesquisado
	 * @return @boolean
	 */
	public boolean hasUmPonto(Ponto ponto) {
		Triangulo t1 = new Triangulo(ponto, ponto2, ponto3);
		Triangulo t2 = new Triangulo(ponto1, ponto, ponto3);
		Triangulo t3 = new Triangulo(ponto1, ponto2, ponto);

		return t1.area() + t2.area() + t3.area() == this.area();

	}

	/**
	 * Retorna o perimetro do triangulo
	 * @return @double
	 */
	public double perimetro() {

		double xy = this.ponto1.getDistancia(ponto2);
		double yz = this.ponto2.getDistancia(ponto3);
		double xz = this.ponto3.getDistancia(ponto1);

		return xy + yz + xz;
	}

}
