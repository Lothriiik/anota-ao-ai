```
SELECT filme.nome

FROM filme

INNER JOIN 
	idioma,
	possuir_audio,
	unidade
	
WHERE
	unidade.codigo_filmeFK = filme.codigo AND
	possuir_audio.codigo_idiomaFK = '1' AND
	idioma.nome = 'Português' AND
	idioma.codigo= '1' AND
	possuir_audio.codigo_unidadeFK = unidade.codigo
```
```
SELECT 
	cliente.nome nome_cliente,
	filme.nome nome_filme
	
FROM cliente

INNER JOIN 
	locar,
	unidade,
	filme
	
WHERE 
	cliente.login = locar.login_clienteFK AND
	locar.codigo_unidadeFK = unidade.codigo and
	unidade.codigo_filmeFK = filme.codigo
```
```
SELECT 
	cliente.nome nome_cliente,
	COUNT(1) quantidade_locacoes
	
FROM cliente

INNER JOIN 
	locar,
	unidade,
	filme
	
WHERE 
	cliente.login = locar.login_clienteFK AND
	locar.codigo_unidadeFK = unidade.codigo and
	unidade.codigo_filmeFK = filme.codigo

GROUP BY cliente.login

ORDER BY quantidade_locacoes DESC, cliente.nome
```
```
SELECT 
	filme.nome,
	COUNT(1) quantidade_locacoes
FROM
	filme
INNER JOIN 
	unidade,
	locar
WHERE
	unidade.codigo = locar.codigo_unidadeFK AND
	filme.codigo = unidade.codigo_filmeFK
GROUP BY filme.codigo

ORDER BY quantidade_locacoes DESC
```
```
SELECT 
	cliente.nome
FROM
	cliente
INNER JOIN 
	unidade,
	locar,
	possuir_legenda,
	idioma i_legenda,
	possuir_audio,
	idioma i_audio
WHERE
	unidade.codigo = locar.codigo_unidadeFK AND
	possuir_legenda.codigo_idiomaFK = i_legenda.codigo AND
	possuir_audio.codigo_idiomaFK = i_audio.codigo AND
	possuir_legenda.codigo_unidadeFK = unidade.codigo AND
	cliente.login = locar.login_clienteFK AND
	possuir_audio.codigo_unidadeFK = possuir_legenda.codigo_unidadeFK AND
	i_audio.nome = "Português" AND
	i_legenda.nome= "Inglês"
```
