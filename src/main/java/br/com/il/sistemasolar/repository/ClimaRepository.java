package br.com.il.sistemasolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Resultado;

/**
 * Classe repository responsavel pelo objeto @Clima
 * @author Ivan Lima
 *
 */
@Repository
public interface ClimaRepository extends CrudRepository<Clima, Long> {
	
	/**
	 * Retorna o objeto @Clima de um determinado dia
	 * @param dia - dia a ser pesquisado
	 * @return @Clima
	 */
	public Clima findByDia(Long dia);
	
	/**
	 * Retorna quantos dia de chuva, seca, otimo e indefinido teremos no periodo x.
	 * @return @List<Resultado>
	 */
	@Query(value = "select new br.com.il.sistemasolar.model.Resultado(c.clima,count(c)) from Clima c group by c.clima")
	public List<Resultado> findResultado();
	
	/**
	 * Retorna uma lista com os dias de maiores periodo de chuva
	 * @return @List<Long>
	 */
	@Query(value = "select dia from clima where clima = 'CHUVA' and perimetro = (select max(perimetro) from clima where clima = 'CHUVA')",nativeQuery = true)
	public List<Long> findDiaMaioresChuva();

}
