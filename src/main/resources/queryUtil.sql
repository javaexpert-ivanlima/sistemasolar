select 
	b.nome
	,b.velocidade
	,c.id
	,c.clima 
	,c.perimetro
	,p.posicao_grau
	,p.valor_radiano
	,p.eixo_x
	,p.eixo_y
from 
	posicao_planeta a
	join planeta b on (a.planeta_id = b.id)
	join clima c on (a.clima_id = c.id)
	join ponto p on (a.posicao_id = p.id)
order by dia