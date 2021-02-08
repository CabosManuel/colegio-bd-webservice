USE bd_mpb_spring;

SELECT * FROM apoderados;
select * from asistencias;
SELECT * FROM cursos;
select * from distritos;
select * from estudiantes;
select * from grados;
select * from horario_cabecera;
select * from horario_detalle;
select * from mallas;
SELECT * FROM matriculas;
SELECT * FROM notas;
select * from notificaciones;
select * from secciones;
select * from trabajadores;


-- --------------------------------
-- CONFIRMAR/RECHAZAR CITACIONES
-- --------------------------------
-- citaciones [estados: P = pendiente (FF9315), V = vencido (FF9315), C = confirmado (14BE58), R = rechazado (F1212B)]
-- permisos [estados: P = pendiente, V = vencido, A = aprobado, D = desaprobado]
update notificaciones set estado = 'V'
where notificacion_id = 1

-- --------------------------------
-- LISTAR DOCENTES
-- --------------------------------
select t.trabajador_id, t.nombres, t.apellidos, t.celular, t.correo, t.sexo, c.curso_id, c.nombre as curso
from trabajadores t
inner join trabajador_curso tc on tc.trabajador_id = t.trabajador_id
inner join cursos c on c.curso_id = tc.curso_id
inner join mallas mll on mll.curso_id = c.curso_id
inner join grados g on g.grado_id = mll.grado_id
inner join matriculas mtr on mtr.grado = g.grado_id
inner join estudiantes e on e.dni_estudiante = mtr.dni_estudiante
where t.cargo = 'docente' and
	e.dni_estudiante = '61933011' and
	year(mtr.fecha) = 2019 /*year(now())*/;

-- --------------------------------
-- PERFIL ESTUDIANTE
-- --------------------------------
SELECT CONCAT(a.nombre, " ", a.apellido) AS apoderado
FROM apoderados a
INNER JOIN estudiantes e ON e.dni_apoderado LIKE a.dni_apoderado
WHERE e.dni_estudiante LIKE '61933011'
;

select * from estudiantes where dni_estudiante LIKE '61933011'

-- --------------------------------
-- CONSULTAR HORARIO
-- --------------------------------
select hd.dia, c.nombre, hd.hora_inicio, hd.hora_fin
from horario_detalle hd
inner join cursos c on c.curso_id = hd.curso_id
inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id
inner join secciones s on s.seccion_id = hc.seccion_id
inner join matriculas m on m.seccion_id = s.seccion_id
inner join estudiantes e on e.dni_estudiante = m.dni_estudiante
where e.dni_estudiante like '61933011' and year(m.fecha) = 2020
;

-- --------------------------------
-- ACCEDER INFO ESTUDIANTES
-- --------------------------------
SELECT e.dni_estudiante, e.nombre, e.apellido
from estudiantes e
where e.dni_apoderado like '06662516'
;
-- --------------------------------
-- LISTAR JUSTIFICACIONES
-- --------------------------------
select j.justificacion_id, j.titulo, j.fecha_envio, j.fecha_justificacion, j.dni_estudiante, j.descripcion
from justificaciones j
where j.dni_estudiante like '61933011'
order by j.fecha_envio desc;

-- --------------------------------
-- PERFIL APODERADO
-- --------------------------------
UPDATE apoderados a
SET a.dni_apoderado ='06662518'

SELECT COUNT(e.dni_estudiante)
FROM estudiantes e
WHERE e.dni_apoderado LIKE '06662516'
;

-- --------------------------------
-- LOGIN
-- --------------------------------
select * from apoderados a
where a.dni_apoderado LIKE '06662516' and a.pass like '12345678'
;

SELECT * FROM estudiantes
where e.dni_estudiante like '61933011' and e.pass like '12345678';
-- --------------------------------
-- BANDEJA DE ENTRADA
-- --------------------------------
select e.dni_estudiante, e.nombre
from estudiantes e
where e.dni_apoderado like '06662516' and e.nombre like 'Nicole'
;
-- titulo, tipo, fecha_envio, fecha_limite, estado, dni_estudiante, descripcion
select n.notificacion_id, n.titulo, n.tipo, n.fecha_envio, n.fecha_limite, n.estado, n.dni_estudiante, n.descripcion
from notificaciones n
where n.dni_estudiante like '61933011' and -- 61933011 comunicado citacion permiso
	(n.tipo like 'citacion' or n.tipo like 'permiso' or n.tipo like 'comunicado')
order by n.fecha_envio desc
;
-- ------------------------------------------------------------------


-- --------------------------------
-- CONSULTAR ASISTENCIAS
-- --------------------------------
-- listar asistencias por dni, curso_id y mes
select a.estado, convert(a.asistencia,date) ,hd.curso_id
from asistencias a
inner join horario_detalle hd
on hd.horario_detalle_id = a.horario_detalle_id
where a.dni_estudiante like '61933011' and hd.curso_id = 21 and month(a.asistencia) = 12;

-- lista meses que tenga asistencias
select distinct month(a.asistencia)
from asistencias a
where a.dni_estudiante like '61933011' and year(a.asistencia) = year(now());

-- listar cursos de la malla más reciente de una estudiante
select cu.curso_id, cu.nombre from cursos cu
inner join mallas mll1 on mll1.curso_id = cu.curso_id
inner join grados g on g.grado_id = mll1.grado_id
inner join matriculas mtr on mtr.grado = g.grado_id
inner join estudiantes e on e.dni_estudiante = mtr.dni_estudiante
where e.dni_estudiante = '61933011' and
	year(mtr.fecha) like 2020 /*year(now())*/;
-- ------------------------------------------------------------------


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


-- REINICIO DE TABLAS

-- NOTIFICACIONES
delete from notificaciones where notificacion_id < 1000;
ALTER TABLE notificaciones AUTO_INCREMENT = 1;

-- ASITENCIAS
delete from asistencias where asistencia_id < 1000;
ALTER TABLE asistencias AUTO_INCREMENT = 1;

-- HORARIO DETALLE
delete from horario_detalle where horario_detalle_id < 1000;
ALTER TABLE horario_detalle AUTO_INCREMENT = 1;

-- HORARIO CABECERA
delete from horario_cabecera where horario_cabecera_id < 1000;
ALTER TABLE horario_cabecera AUTO_INCREMENT = 1;

-- trabajador_curso
delete from trabajador_curso where trabajador_id < 1000;
alter table trabajador_curso AUTO_INCREMENT = 1;

-- trabajador
delete from trabajadores where trabajador_id < 1000;
alter table trabajadores AUTO_INCREMENT = 1; 

-- JUSTIFICACIONES
delete from justificaciones where justificacion_id < 1000;
ALTER TABLE justificaciones AUTO_INCREMENT = 1;