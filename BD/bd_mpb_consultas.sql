use bd_mpb;

SELECT * FROM apoderado;
SELECT * FROM curso;
select * from estudiante;
select * from grado;
SELECT * FROM matricula;
select * from seccion;


-- listar nivel, grado y sesciones
select s.id_seccion, n.nombre as nivel, concat(g.nombre,' ',s.nombre) as 'grado y seccion'
from nivel n
inner join grado g on g.id_nivel = n.id_nivel
inner join seccion s on s.id_grado = g.id_grado;

-- listar estudiantes dni, nombre, grado y seccion 
SELECT 
	mat.dni_estudiante, 
	est.nombres, 
	concat(gra.nombre,sec.nombre) AS 'grado y seccion'
FROM matricula mat
	INNER JOIN estudiante est
	ON est.dni = mat.dni_estudiante
	INNER JOIN seccion sec
	ON sec.id_seccion = mat.id_seccion
	INNER JOIN grado gra
	ON gra.id_grado = mat.grado
ORDER BY gra.id_grado

-- listar cursos por grado
SELECT c.id_curso,c.nombre
FROM malla m
	INNER JOIN curso c
	ON c.id_curso = m.id_curso
WHERE m.id_grado = 14;
