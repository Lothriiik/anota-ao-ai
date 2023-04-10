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
```
SELECT 
	filme.nome, 
	cliente.nome
FROM
	filme LIKE "a%"
INNER JOIN 
	unidade,
	locar,
	cliente
WHERE
	unidade.codigo_filmeFK = filme.codigo AND
	unidade.codigo = locar.codigo_unidadeFK AND
	locar.login_clienteFK = cliente.login AND
	cliente.nome LIKE "a%"
```
```
SELECT 
	filme.nome, 
	c.nome
FROM
	filme
INNER JOIN 
	unidade,
	locar,
	(SELECT * FROM cliente WHERE nome LIKE "a%") c
WHERE
	unidade.codigo_filmeFK = filme.codigo AND
	unidade.codigo = locar.codigo_unidadeFK AND
	locar.login_clienteFK = c.login 
	
```
```
SELECT codigo

FROM filme

WHERE codigo NOT IN 
(
SELECT 
DISTINCT
	unidade.codigo_filmeFK
	
FROM
	locar
	
INNER JOIN 
	unidade
	
WHERE
	unidade.codigo = locar.codigo_unidadeFK 
)

```
questão 1
```
SELECT 
	cliente.nome,
	COUNT(1) quantidade_locacoes
FROM
	cliente
INNER JOIN 
	locar
WHERE
	cliente.login = locar.login_clienteFK
	
GROUP BY cliente.login

ORDER BY quantidade_locacoes DESC
```
questão 2
```
SELECT nome

FROM cliente

WHERE login NOT IN 
(
SELECT 

cliente.nome
	
FROM
	locar
	
INNER JOIN 
	unidade,
	filme,
	cliente
	
WHERE
	unidade.codigo = locar.codigo_unidadeFK and
	filme.codigo = unidade.codigo_filmeFK and
	filme.nome = 'Titanic' and
	locar.login_clienteFK = cliente.login
)
```
	
	
	

	
	
	




