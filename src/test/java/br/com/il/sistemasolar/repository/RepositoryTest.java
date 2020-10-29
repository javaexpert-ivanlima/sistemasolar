package br.com.il.sistemasolar.repository;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Planeta;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class RepositoryTest {


	@Autowired
	private ClimaRepository climaRepository ;
	
	@Autowired
	private PlanetaRepository planetaRepository ;

	@Autowired
	private PontoRepository pontoRepository ;

	@Autowired
	private PosicaoPlanetaRepository posicaoPlanetaRepository ;
	
	@Test
	public void testSaveClima() {
		Clima clima = new Clima(0L,"INDEFINIDO",0.0);
		climaRepository.save(clima);
		assertNotNull(climaRepository.findById(0L));
	}

	@Test
	public void testSavePlaneta() {
		Planeta jupiter = new Planeta("Jupiter", 23L, 450L);
		jupiter.setId(23L);
		jupiter.setAntihorario(true);
		planetaRepository.save(jupiter);
		assertNotNull(planetaRepository.findByNome("Jupiter"));
	}


}