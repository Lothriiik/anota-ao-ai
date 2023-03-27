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
