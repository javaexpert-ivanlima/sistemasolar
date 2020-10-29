package br.com.il.sistemasolar.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.il.sistemasolar.repository.ClimaRepository;
import br.com.il.sistemasolar.repository.PlanetaRepository;
import br.com.il.sistemasolar.repository.PontoRepository;
import br.com.il.sistemasolar.repository.PosicaoPlanetaRepository;


@RunWith(JUnit4.class)
public class SistemaSolarTest {
	
	private SistemaSolar sistemaSolar;
	
	@Mock
	private ClimaRepository climaRepository;

	@Mock 
	private PlanetaRepository planetaRepository;
	
	@Mock
	private PontoRepository pontoRepository;
	
	@Mock
	private PosicaoPlanetaRepository posicaoPlanetaRepository;

	
	
	@Before	
	public void before() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		sistemaSolar = new SistemaSolar();
		sistemaSolar.setPlanetaRepository(planetaRepository);
		sistemaSolar.setPontoRepository(pontoRepository);
		sistemaSolar.setClimaRepository(climaRepository);
		sistemaSolar.setPosicaoPlanetaRepository(posicaoPlanetaRepository);
		
		when(planetaRepository.save(any())).thenReturn(null);
		when(pontoRepository.save(any())).thenReturn(null);
		when(climaRepository.save(any())).thenReturn(null);
		when(posicaoPlanetaRepository.save(any())).thenReturn(null);
		
	}

	@Test
	public void testCreate() {
		sistemaSolar.iniciaPrevisao(null);
		assertNotNull(sistemaSolar);
	}
	
	@Test
	public void testAllPlanets() {
		assertEquals(3, sistemaSolar.getAllPlanets().size());
	}
	
	
}
