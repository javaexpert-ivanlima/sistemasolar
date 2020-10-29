package br.com.il.sistemasolar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Resultado;
import br.com.il.sistemasolar.repository.ClimaRepository;


@RunWith(JUnit4.class)
public class ClimaServiceTest {
	
	private ClimaService service;
	
	private Clima clima;
	private List<Resultado> lstResultados;
	private List<Long> lstDias;
	
	
	@Mock
	private ClimaRepository climaRepository;

	@Before	
	public void before() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		service = new ClimaService();
		service.setClimaRepository(climaRepository);
		
		clima = new Clima();
		clima.setClima("CHUVA");
		clima.setDia(1L);
		
		Resultado r = new Resultado();
		r.setClima("SECA");
		r.setDias(34L);
		
		lstResultados = new ArrayList<Resultado>();
		lstResultados.add(r);
		
		lstDias = new ArrayList<Long>();
		lstDias.add(5L);
		
		when(climaRepository.findByDia(any())).thenReturn(clima);
		when(climaRepository.findResultado()).thenReturn(lstResultados);
		when(climaRepository.findDiaMaioresChuva()).thenReturn(lstDias);
		
	}

	@Test
	public void testPrevisao() {
		
		assertEquals(clima, service.getPrevisao(1L));
	}

	@Test
	public void testResultado() {
		
		assertEquals(lstResultados, service.getResultado());
	}
	
	@Test
	public void testMaiorPeriodoDeChuva() {
		
		assertEquals(lstDias, service.getDiaMaiorPeriodoDeChuva());
	}

}
