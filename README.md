
SELECT filme.nome
FROM filme
INNER JOIN 
	idioma,
	possuir_audio,
	unidade
WHERE unidade.codigo_filmeFK = filme.codigo AND
	possuir_audio.codigo_idiomaFK = '1' AND
	idioma.nome = 'Português' AND
	idioma.codigo= '1' AND
	possuir_audio.codigo_unidadeFK = unidade.codigo
   
   
