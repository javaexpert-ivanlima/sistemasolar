package br.com.il.sistemasolar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.il.sistemasolar.model.PosicaoPlaneta;

/**
 * Classe repository responsavel pelas operacoes do objeto PosicaoPlaneta
 * @author Ivan Lima
 *
 */
@Repository
public interface PosicaoPlanetaRepository extends CrudRepository<PosicaoPlaneta, Long> {
	
	
}
