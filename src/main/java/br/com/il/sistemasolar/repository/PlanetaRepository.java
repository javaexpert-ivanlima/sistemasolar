package br.com.il.sistemasolar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.il.sistemasolar.model.Planeta;

/**
 * Classe repository repsonsavel pela classe @Planeta
 * @author Ivan Lima
 *
 */
@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {
	/**
	 * Retorna um planeta pelo nome
	 * @param nome - nome do planeta a ser pesquisado
	 * @return @Planeta
	 */
	public Planeta findByNome(String nome);
	
}
