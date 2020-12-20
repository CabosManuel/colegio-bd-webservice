USE bd_spring_mpb;

SELECT * FROM apoderados;
SELECT * FROM cursos;
select * from estudiantes;
select * from grados;
select * from mallas;
SELECT * FROM matriculas;
select * from secciones;

select distinct c.nombre,n.nota1,n.nota2,n.nota3, year(n.fecha)
from notas n 
inner join cursos c on c.curso_id=n.curso_id 
inner join estudiantes e on e.dni_estudiante = n.dni_estudiante 
where year(n.fecha) = '2019' and e.dni_estudiante = '61933011';

select distinct year(n.fecha) from notas n inner join estudiantes e on e.dni_estudiante = n.dni_estudiante where e.dni_estudiante = '61933011';

-- listar nivel, grado y sesciones
select s.seccion_id, n.nombre as niveles, concat(g.nombre,' ',s.nombre) as 'grado y seccion'
from niveles n
inner join grados g on g.nivel_id = n.nivel_id
inner join secciones s on s.grado_id = g.grado_id;

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