package br.com.il.sistemasolar.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.il.sistemasolar.model.Clima;
import br.com.il.sistemasolar.model.Planeta;
import br.com.il.sistemasolar.model.Ponto;
import br.com.il.sistemasolar.model.PosicaoPlaneta;
import br.com.il.sistemasolar.repository.ClimaRepository;
import br.com.il.sistemasolar.repository.PlanetaRepository;
import br.com.il.sistemasolar.repository.PontoRepository;
import br.com.il.sistemasolar.repository.PosicaoPlanetaRepository;

/**
 * Classe responsavel por fazer a carga do periodo x anos e popular com o clima
 * @author Ivan Lima
 *
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SistemaSolar {
	
		private List<Planeta> listPlanets;
		private Planeta sol;
		
		@Autowired
		private ClimaRepository climaRepository;
		@Autowired
		private PlanetaRepository planetaRepository;
		@Autowired
		private PontoRepository pontoRepository;
		@Autowired
		private PosicaoPlanetaRepository posicaoPlanetaRepository;

		
		public SistemaSolar() {
			this.listPlanets  = new ArrayList<Planeta>();
			Planeta vulcano   = new Planeta("Vulcano", 500L, 1L,true);
			Planeta ferrengi  = new Planeta("Ferrengi", 2000L, 3L,true);
			Planeta betasoide = new Planeta("Betasoide", 1000L, 5L,false);
			sol = new Planeta("Sol", 0L, 0L);
			
			this.listPlanets.add(vulcano);
			this.listPlanets.add(ferrengi);
			this.listPlanets.add(betasoide);
			
		}

		/**
		 * Retorna uma lista de todos planetas que compoe o sistema solar
		 * @return @List<Planeta>
		 */
		public List<Planeta> getAllPlanets(){
			return listPlanets;
		}
		
		/**
		 * Retorna o planeta Sol
		 * @return @Planeta
		 */
		public Planeta getSol() {
			return sol;
		}
		
		/**
		 * Retorna o planeta Vulcano
		 * @return @Planeta
		 */
		public Planeta getVulcano() {
			return listPlanets.get(0);
		}
		
		/**
		 * Retorna o planeta Ferrengi
		 * @return @Planeta
		 */
		public Planeta getFerrengi() {
			return listPlanets.get(1);
		}
		
		/**
		 * Retorna o planeta Betasoide
		 * @return @Planeta
		 */
		public Planeta getBetasoide() {
			return listPlanets.get(2);
		}
		
		
		/**
		 * Inica a base com o calculo de clima dia apos dia 
		 * @param anos - periodo de quantos anos para inicializar a base
		 */
		public void iniciaPrevisao(Long anos) {
			
			Planeta vulcano = this.getVulcano();
			Planeta ferrengi = this.getFerrengi();
			Planeta betasoide = this.getBetasoide();
			Ponto sol  = this.getSol().getPosicao(0);
			planetaRepository.save(vulcano);
			planetaRepository.save(ferrengi);
			planetaRepository.save(betasoide);

			if (anos == null) {
				anos = 10L;
			}
			
			for(long dia=0;dia<=365*anos;dia++) {
				
				Ponto posicaoVulcano = vulcano.getPosicao(dia);
				pontoRepository.save(posicaoVulcano);
				Ponto posicaoBetasoide = betasoide.getPosicao(dia);
				pontoRepository.save(posicaoBetasoide);
				Ponto posicaoFerrengi = ferrengi.getPosicao(dia);
				pontoRepository.save(posicaoFerrengi);
				
				//verifica se os 3 pontos são uma reta
				boolean isReta = Ponto.isLinear(posicaoVulcano, posicaoBetasoide, posicaoFerrengi);
				ClimaEnum clima = ClimaEnum.INDEFINIDO;
				double perimetro = 0.0;
				if (isReta) {
					//planetas alinhados com o sol
					if (Ponto.isLinear(sol, posicaoBetasoide, posicaoFerrengi)) {
						clima = ClimaEnum.SECA;
					}else {
						clima = ClimaEnum.OTIMO;
					}
					
				}else { //triangulo
					Triangulo triangulo = new Triangulo(posicaoVulcano, posicaoBetasoide, posicaoFerrengi);
					perimetro = triangulo.perimetro();
					//se o sol estiver dentro do triangulo
					if (triangulo.hasUmPonto(sol)) {
						clima = ClimaEnum.CHUVA;
					}else {
						clima = ClimaEnum.INDEFINIDO;
					}
				}
				Clima periodo = new Clima(dia, clima.getDescricao(),perimetro);
				climaRepository.save(periodo);
			    PosicaoPlaneta posicaoPlanetaVulcano = new PosicaoPlaneta(vulcano,posicaoVulcano,periodo);
			    posicaoPlanetaRepository.save(posicaoPlanetaVulcano);
			    PosicaoPlaneta posicaoPlanetaFerrengi = new PosicaoPlaneta(ferrengi,posicaoFerrengi,periodo);
			    posicaoPlanetaRepository.save(posicaoPlanetaFerrengi);
			    PosicaoPlaneta posicaoPlanetaBetasoide = new PosicaoPlaneta(betasoide,posicaoBetasoide,periodo);
			    posicaoPlanetaRepository.save(posicaoPlanetaBetasoide);

			}
		}

		public void setPlanetaRepository(PlanetaRepository planetaRepository) {
			this.planetaRepository = planetaRepository;
		}

		public void setPontoRepository(PontoRepository pontoRepository) {
			this.pontoRepository = pontoRepository;
		}

		public void setPosicaoPlanetaRepository(PosicaoPlanetaRepository posicaoPlanetaRepository) {
			this.posicaoPlanetaRepository = posicaoPlanetaRepository;
		}

		public void setClimaRepository(ClimaRepository climaRepository) {
			this.climaRepository = climaRepository;
		}	
		
}
