package br.com.il.sistemasolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Resultado;
import br.com.il.sistemasolar.service.ClimaService;

/**
 * Classe responsavel pela API do sistema
 * @author Ivan Lima
 *
 */
@RestController
@RequestMapping("/api")
public class ClimaController {

	@Autowired
	private ClimaService climaService;
	
	/**
	 * Retorna o objeto @Clima para um determinado dia
	 * @param day - dia a ser pesquisado o clima
	 * @return @Clima 
	 */
	@GetMapping(value = "/clima")
	public Clima getPrevisao(@RequestParam long day) {
			return climaService.getPrevisao(day);
	}

	/**
	 * Verifica quantos periodos de chuva, seca, otimo e indefinido terão no periodo de x anos
	 *  
	 * @return @Resultado
	 */
	@GetMapping(value = "/resultado")
	public List<Resultado> getResultado() {
			return climaService.getResultado();
	}
	/**
	 * Retorno uma lista de dia com os maiores dia de chuva durante o periodo de x anos
	 * @return @Long
	 */
	@GetMapping(value = "/maioresdiadechuva")
	public List<Long> getDiaMaiorPeriodoDeChuva() {
		return climaService.getDiaMaiorPeriodoDeChuva();
	}

	public void setClimaService(ClimaService climaService) {
		this.climaService = climaService;
	}

	
}
