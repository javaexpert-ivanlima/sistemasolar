package br.com.il.sistemasolar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.il.sistemasolar.model.Ponto;

/**
 * Classe repository responsavel pelo objeto @Ponto
 * @author Ivan Lima
 *
 */
@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long> {
	
	/**
	 * Retorna um lista de pontoso atraves do dia
	 * @param dia - dia a ser pesquisado
	 * @return @List<Ponto>
	 */
	public List<Ponto> findByDia(Long dia);
	
}
