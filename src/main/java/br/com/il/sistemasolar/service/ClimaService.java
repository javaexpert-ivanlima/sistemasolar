package br.com.il.sistemasolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Resultado;
import br.com.il.sistemasolar.repository.ClimaRepository;

/**
 * Classe @service responsavel pela logica de negocio
 * @author Ivan Lima
 *
 */
@Service
public class ClimaService {
	
	@Autowired
	private ClimaRepository climaRepository;

	/**
	 * Retorna a previsao do clima para um determinado dia
	 * @param day - dia  a ser pesquisado
	 * @return @Clima
	 */
	public Clima getPrevisao(long day) {
		return climaRepository.findByDia(day);
	}
	
	/**
	 * Retorna o resultado de quantos dia de chuva,seca,otimo e indefinido terão no periodo.
	 * @return @List<Resultado>
	 */
	public List<Resultado> getResultado() {
		return climaRepository.findResultado();
	}
	
	/**
	 * Retorna os dias que terão maiores periodo de chuva
	 * @return @List<Long>
	 */
	public List<Long> getDiaMaiorPeriodoDeChuva() {
		return climaRepository.findDiaMaioresChuva();
	}

	public void setClimaRepository(ClimaRepository climaRepository) {
		this.climaRepository = climaRepository;
	}
	
}
