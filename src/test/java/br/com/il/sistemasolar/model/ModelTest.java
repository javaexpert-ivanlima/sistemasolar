package br.com.il.sistemasolar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;


@RunWith(JUnit4.class)
public class ModelTest {
	
	@Before	
	public void before() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		
	}

	@Test
	public void testResultado() {
		
		Resultado result = new Resultado("CHUVA",14L);
		assertEquals(result.getClima(), "CHUVA");
		assertTrue(result.getDias()== 14L);
	}
	
	@Test
	public void testPosicaoPlaneta() {
		
		Planeta sol = new Planeta("Sol", 0L, 0L);
		Clima clima = new Clima(0L,"INDEFINIDO",0.0);
		Ponto ponto = new Ponto(0.0, 0.0);
		
		PosicaoPlaneta posicaoPlaneta = new PosicaoPlaneta(sol, ponto, clima);
		
		assertEquals(posicaoPlaneta.getPlaneta(), sol);
		assertEquals(posicaoPlaneta.getClima(), clima);
		assertEquals(posicaoPlaneta.getPosicao(), ponto);
		
		posicaoPlaneta.setId(1L);
		assertTrue(posicaoPlaneta.getId()== 1L);
	}



	@Test
	public void testPonto() {
		Planeta sol = new Planeta("Sol", 0L, 0L);
		Ponto ponto = new Ponto(0.0, 0.0);
		
		ponto.setId(1L);
		ponto.setDia(1L);
		ponto.setPosicaoEmGraus(45.0);
		ponto.setPosicaoEmRadianos(0.73);
		ponto.setPlaneta(sol);
		
		assertTrue(ponto.getDia() == 1L);
		assertTrue(ponto.getId() == 1L);
		assertTrue(ponto.getPosicaoEmGraus() == 45.0);
		assertTrue(ponto.getPosicaoEmRadianos() == 0.73);
		assertEquals(ponto.getPlaneta(), sol);
		
		assertEquals(ponto.toString(), "Coordenas do ponto[x=0.0, y=0.0]");

	}

	@Test
	public void testPlaneta() {
		Planeta sol = new Planeta("Sol", 0L, 0L);
		sol.setId(1L);
		sol.setAntihorario(true);
		
		assertEquals(sol.getNome(), "Sol");
		assertTrue(sol.getId() == 1L);
		assertTrue(sol.isAntihorario());

	}

	
	@Test
	public void testClima() {
		
		Clima clima = new Clima(0L,"INDEFINIDO");
		clima.setPerimetro(6.0);
		
		assertEquals(clima.getClima(), "INDEFINIDO");
		assertTrue(clima.getPerimetro()== 6.0);
	}

}
