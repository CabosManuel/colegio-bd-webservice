USE bd_spring_mpb;

SELECT * FROM apoderados;
select * from asistencias;
SELECT * FROM cursos;
select * from estudiantes;
select * from grados;
select * from mallas;
SELECT * FROM matriculas;
select * from secciones;

-- listar asistencias en cada mes
select a.estado, convert(a.asistencia,date) 
from asistencias a
where week(a.asistencia) between week('2020-11-01') and (week(last_day('2020-11-01')))
group by dayofyear(convert(a.asistencia,date));

-- listar cursos de la malla más reciente de una estudiante
select cu.curso_id, cu.nombre from cursos cu
inner join mallas mll1 on mll1.curso_id = cu.curso_id
inner join grados g on g.grado_id = mll1.grado_id
inner join matriculas mtr on mtr.grado = g.grado_id
inner join estudiantes e on e.dni_estudiante = mtr.dni_estudiante
where e.dni_estudiante = '61933011' and
	year(mtr.fecha) like year(now());

-- seleccionar curso y notas por el DNI del estudiante
select distinct c.nombre,n.nota1,n.nota2,n.nota3, year(n.fecha)
from notas n 
inner join cursos c on c.curso_id=n.curso_id 
inner join estudiantes e on e.dni_estudiante = n.dni_estudiante 
where year(n.fecha) = '2020' and e.dni_estudiante = '61933011';

-- selecionar los años del estudiante (tal vez se debería recuperar los años de la matrícula y no de las notas)
select distinct year(n.fecha) 
from notas n 
inner join estudiantes e on e.dni_estudiante = n.dni_estudiante 
where e.dni_estudiante = '61933011';

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
SELECT c.curso_id,c.nombre
FROM mallas m
	INNER JOIN cursos c
	ON c.curso_id = m.curso_id
WHERE m.grado_id = 14;


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