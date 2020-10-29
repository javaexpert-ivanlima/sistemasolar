package br.com.il.sistemasolar.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;


@RunWith(JUnit4.class)
public class EnumTest {
	
	@Before	
	public void before() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		
	}

	@Test
	public void testEnums() {
		ClimaEnum.SECA.getDescricao();
		ClimaEnum.CHUVA.getDescricao();
		ClimaEnum.OTIMO.getDescricao();
		ClimaEnum.INDEFINIDO.getDescricao();

		
		assertTrue(true);
	}


}
