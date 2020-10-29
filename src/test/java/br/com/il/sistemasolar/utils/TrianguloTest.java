package br.com.il.sistemasolar.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

import br.com.il.sistemasolar.model.Ponto;


@RunWith(JUnit4.class)
public class TrianguloTest {
	
	private Triangulo t;
	private Ponto p1;
	private Ponto p2;
	private Ponto p3;
	
	
	@Before	
	public void before() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		this.p1 = new Ponto(-1.0,0.0);
		this.p2 = new Ponto(1.0,0.0);
		this.p3 = new Ponto(0.0,1.0);
		this.t = new Triangulo(p1, p2, p3);
		
		
	}

	@Test
	public void testCreate() {
		assertEquals(p1, t.getPonto1());
		assertEquals(p2, t.getPonto2());
		assertEquals(p3, t.getPonto3());
		
	}
	@Test
	public void testHasPonto() {
		assertTrue(t.hasUmPonto(new Ponto(0.0,0.0)));	
	}

	@Test
	public void testHasNoPonto() {
		assertFalse(t.hasUmPonto(new Ponto(25.0,5.0)));	
	}
	
	@Test
	public void testArea() {
		assertEquals(1.0, t.area(),0);	
	}

	@Test
	public void testPerimetro() {
		assertEquals(6.0, t.perimetro(),0);	
	}


}
