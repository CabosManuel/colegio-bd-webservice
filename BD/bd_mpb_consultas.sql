use bd_mpb;

SELECT * FROM apoderado;
SELECT * FROM curso;
select * from estudiante;
select * from grado;
select * from malla;
SELECT * FROM matricula;
select * from seccion;

select distinct c.nombre,n.nota_1,n.nota_2,n.nota_3
from nota n
inner join curso c on c.id_curso=n.id_curso
inner join estudiante e on e.dni = n.dni_estudiante
where year(n.fecha) = '2019' and
	e.dni = '87341016';


-- listar nivel, grado y sesciones
select s.id_seccion, n.nombre as nivel, concat(g.nombre,' ',s.nombre) as 'grado y seccion'
from nivel n
inner join grado g on g.id_nivel = n.id_nivel
inner join seccion s on s.id_grado = g.id_grado;

-- listar estudiantes dni, nombre, grado y seccion 
SELECT 
	mat.dni_estudiante, 
	est.nombres, 
	concat(gra.nombre,sec.nombre) AS 'grado y seccion',
    sec.id_seccion, gra.id_grado
FROM matricula mat
	INNER JOIN estudiante est
	ON est.dni = mat.dni_estudiante
	INNER JOIN seccion sec
	ON sec.id_seccion = mat.id_seccion
	INNER JOIN grado gra
	ON gra.id_grado = mat.grado
ORDER BY gra.id_grado;

-- listar cursos por grado
SELECT c.id_curso,c.nombre
FROM malla m
	INNER JOIN curso c
	ON c.id_curso = m.id_curso
WHERE m.id_grado = 14;


-- listar horario? (no actualizado)
/*
SELECT 
 e.nombres,
 a.estado,
 hd.fecha,
 c.nombre
FROM asistencia a
INNER JOIN estudiante e ON e.dni = a.dni_estudiante
INNER JOIN horario_detalle hd ON a.id_horario_detalle = hd.id_horario_detalle
INNER JOIN curso c ON hd.id_curso = c.id_curso;
*/