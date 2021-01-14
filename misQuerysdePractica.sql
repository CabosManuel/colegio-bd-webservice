-- Mis querys 
use bd_webservicerest;

insert into distritos(nombre) VALUES ('LA VICTORIA');
insert into distritos(nombre) VALUES ('LA MOLINA');

insert into apoderados(dni_apoderado, nombre, apellido, correo, distrito_id, celular, pass, estado) values('76768987','Michelli','Eyzaguirre','michelli@hotmail.com',1,'987887789','M1234',1);

insert into estudiantes(dni_estudiante,nombre, apellido, correo, celular, direccion, pass, fnacimiento, dni_apoderado, distrito_id, estado) values('76758987','Miooelli','Eyzaguirre','mimmmi@hotmail.com','900887789','dfsdfd56', 'ddd', '2020-03-04', '76768987',1, 1);

insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Maria Miranda','Ortaliza Merino', 'Recepcionista','mariaortaliza@hotmail.com','900087789','Av. Ramirez 123', '78989090', '1990-03-04', '123456',1, 1);
insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Juan Benigno','Lopez Torres', 'Docente','juanbenigno@hotmail.com','966087789','Av. Las Flores 234', '78019090', '1993-06-01', 'j123456',2, 1);
insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Ramona Sheyla','Gonzales Pachas', 'Directora','ramonasheyla@hotmail.com','988087789','Av. Aviación 89', '70089090', '1985-01-06', 'r123456',1, 1);
--
insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Robert','Merino', 'Docente','robertmerino@hotmail.com','900088888','Av. Luri 123', '70089090', '1990-03-04', '123456',1, 1);
insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Raul','Lopez', 'Docente','raullopez@hotmail.com','900088808','Av. Los Laureles 134', '79019090', '1993-06-01', 'j123456',2, 1);
insert into trabajadores(nombres, apellidos, cargo, correo, celular, direccion, dni, fecha_nacimiento, pass, distrito_id, estado) 
values('Ramonilla','Gonzales', 'Docente','ramonillagonzales@hotmail.com','900008888','Av. Aviación 189', '73089090', '1985-01-06', 'r123456',1, 1);

insert into cursos (creditos, nombre) values(3, 'MATEMATICA');
insert into cursos (creditos, nombre) values(3, 'COMUNICACION');
insert into cursos (creditos, nombre) values(3, 'PERSONAL SOCIAL');
insert into cursos (creditos, nombre) values(3, 'ARTE');
insert into cursos (creditos, nombre) values(3, 'RELIGION');
insert into cursos (creditos, nombre) values(3, 'CIENCIA');
insert into cursos (creditos, nombre) values(3, 'INGLES');
insert into cursos (creditos, nombre) values(3, 'BLABLA');

insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 14, 15, 16, 1, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 07, 06, 2, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 07, 06, 3, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 18, 07, 06, 4, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 19, 16, 5, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 07, 06, 6, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 13, 06, 7, '76758987');
insert into notas (fecha, nota1, nota2, nota3, curso_id, dni_estudiante) values('2019-03-15', 11, 09, 16, 8, '76758987');

INSERT INTO niveles (nombre) VALUES ('inicial');
INSERT INTO niveles (nombre) VALUES ('primaria');
INSERT INTO niveles (nombre) VALUES ('secundaria');

-- grado (14)
-- inicial (3)
-- A
INSERT INTO grados (nombre, nivel_id) VALUES ('3 años', 1);
INSERT INTO grados (nombre, nivel_id) VALUES ('4 años', 1);
INSERT INTO grados (nombre, nivel_id) VALUES ('5 años', 1);
 -- primaria (6)
INSERT INTO grados (nombre, nivel_id) VALUES ('1ro', 2);
INSERT INTO grados (nombre, nivel_id) VALUES ('2do', 2);
INSERT INTO grados (nombre, nivel_id) VALUES ('3ro', 2);
INSERT INTO grados (nombre, nivel_id) VALUES ('4to', 2);
INSERT INTO grados (nombre, nivel_id) VALUES ('5to', 2);
INSERT INTO grados (nombre, nivel_id) VALUES ('6to', 2);
 -- secundaria (5)
INSERT INTO grados (nombre, nivel_id) VALUES ('1ro', 3);
INSERT INTO grados (nombre, nivel_id) VALUES ('2do', 3);
INSERT INTO grados (nombre, nivel_id) VALUES ('3ro', 3);
INSERT INTO grados (nombre, nivel_id) VALUES ('4to', 3);
INSERT INTO grados (nombre, nivel_id) VALUES ('5to', 3);
 
-- seccion (42)
-- inicial
-- A
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 1);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 2);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 3);
-- B
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 1);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 2);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 3);
-- C
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 1);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 2);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 3);
		
-- primaria
-- A
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 4);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 5);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 6);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 7);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 8);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 9);
-- B
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 4);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 5);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 6);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 7);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 8);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 9);
-- C
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 4);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 5);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 6);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 7);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 8);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 9);
-- secundaria
-- A
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 10);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 11);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 12);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 13);
INSERT INTO secciones (nombre, grado_id) VALUES ('A', 14);
-- B
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 10);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 11);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 12);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 13);
INSERT INTO secciones (nombre, grado_id) VALUES ('B', 14);
-- C
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 10);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 11);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 12);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 13);
INSERT INTO secciones (nombre, grado_id) VALUES ('C', 14);

insert into mallas (curso_id, grado_id) values (1,4);
insert into mallas (curso_id, grado_id) values (2,4);
insert into mallas (curso_id, grado_id) values (3,4);
insert into mallas (curso_id, grado_id) values (4,4);
insert into mallas (curso_id, grado_id) values (5,4);
insert into mallas (curso_id, grado_id) values (6,4);
insert into mallas (curso_id, grado_id) values (7,4);
insert into mallas (curso_id, grado_id) values (8,4);

insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2019-02-12 15:32:03', 2, 4, 76758987, 10);

select n.nombre as Nivel, g.nombre as Grado, s.nombre as Seccion from matriculas m
inner join secciones s on m.seccion_id = s.seccion_id
inner join grados g on s.grado_id = g.grado_id
inner join niveles n on g.nivel_id = n.nivel_id
inner join estudiantes e on m.dni_estudiante = e.dni_estudiante

-- Para el próximo año
select if(e.condicion = 'Promovido' and g.grado_id > 9, n.nivel_id + 1, n.nivel_id) as Nivel,
if(e.condicion = 'Promovido', g.grado_id + 1, g.grado_id) as Grado, s.seccion_id as Seccion
from matriculas m
inner join secciones s on m.seccion_id = s.seccion_id
inner join grados g on s.grado_id = g.grado_id
inner join niveles n on g.nivel_id = n.nivel_id
inner join estudiantes e on m.dni_estudiante = e.dni_estudiante
where e.dni_estudiante = '76758987'
ORDER by m.matricula_id DESC
LIMIT 1

select * from mallas;
select * from secciones;
select * from grados;
select * from niveles;
select * from trabajadores;

SELECT *
FROM matriculas
ORDER by matricula_id DESC
LIMIT 1

select s.nombre from secciones s inner join grados g on s.grado_id = g.grado_id
where g.grado_id = 4

select g.nombre as Grado, s.nombre as Seccion from secciones s
inner join grados g on s.grado_id = g.grado_id 
inner join niveles n on g.nivel_id = n.nivel_id
where n.nivel_id =1;

use bd_webservicerest;

select * from horario_cabecera;
select * from horario_detalle;

insert into horario_cabecera (estado, seccion_id, trabajador_id) values (1,10,3);
insert into horario_detalle (dia, hora_fin, hora_inicio, curso_id, horario_cabecera_id) values ('Lunes', '09:00', '07:00', 1, 1);
insert into horario_detalle (dia, hora_fin, hora_inicio, curso_id, horario_cabecera_id) values ('Martes', '09:00', '07:00', 2, 1);

select * from cursos;
select * from trabajadores;
select * from trabajador_curso;

insert into trabajador_curso (trabajador_id, curso_id) values (2,1),(4,2),(5,3),(6,4),(2,5),(4,6);
insert into trabajador_curso (trabajador_id, curso_id) values (4,1);

-- Query para hallar los cursos por nivel y grado
select c.curso_id, c.nombre from cursos c
inner join mallas m on c.curso_id = m.curso_id
inner join grados g on g.grado_id = m.grado_id
inner join niveles n on g.nivel_id = n.nivel_id
where n.nivel_id = 2 and g.grado_id = 4;

select t.trabajador_id, t.nombres from trabajadores t
inner join trabajador_curso tc on t.trabajador_id = tc.trabajador_id
inner join cursos c on tc.curso_id = c.curso_id
where c.curso_id = 2;

select * from grados g
inner join niveles n on g.nivel_id = n.nivel_id
where n.nivel_id = 1;

-- Consultar horario
select * from horario_detalle hd
inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id
inner join secciones s on hc.seccion_id = s.seccion_id
inner join trabajadores t on hd.trabajador_id = t.trabajador_id
where s.seccion_id = 10 and t.trabajador_id = 4;

select * from estudiantes e
inner join matriculas m on e.dni_estudiante = m.dni_estudiante
inner join secciones s on m.seccion_id = s.seccion_id
where s.seccion_id = 10

select * from horario_cabecera hc
			inner join horario_detalle hd on hc.horario_cabecera_id = hd.horario_cabecera_id
			inner join secciones s on hc.seccion_id = s.seccion_id
			inner join trabajadores t on hd.trabajador_id = t.trabajador_id
			where s.seccion_id = 10 and t.trabajador_id = 4
            

select m.matricula_id, e.dni_estudiante, m.fecha, s.seccion_id, if(e.condicion = 'Promovido' and g.grado_id > 9, n.nivel_id + 1, n.nivel_id) as Nivel,
						if(e.condicion = 'Promovido', g.grado_id + 1, g.grado_id) as Grado, s.seccion_id as Seccion
						from matriculas m
						inner join secciones s on m.seccion_id = s.seccion_id
						inner join grados g on s.grado_id = g.grado_id
						inner join niveles n on g.nivel_id = n.nivel_id
						inner join estudiantes e on m.dni_estudiante = e.dni_estudiante
						where e.dni_estudiante = 76758987
                        ORDER by m.matricula_id DESC LIMIT 1;
                        
UPDATE estudiantes e
SET e.condicion ='Promovido' 
where e.dni_estudiante = '76758987';