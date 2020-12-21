USE bd_spring_mpb;

-- distritos (43)
INSERT INTO distritos (nombre) VALUES ('LIMA');
INSERT INTO distritos (nombre) VALUES ('ANCÓN');
INSERT INTO distritos (nombre) VALUES ('ATE');
INSERT INTO distritos (nombre) VALUES ('BARRANCO');
INSERT INTO distritos (nombre) VALUES ('BREÑA');
INSERT INTO distritos (nombre) VALUES ('CARABAYLLO');
INSERT INTO distritos (nombre) VALUES ('CHACLACAYO');
INSERT INTO distritos (nombre) VALUES ('CHORRILLOS');
INSERT INTO distritos (nombre) VALUES ('CIENEGUILLA');
INSERT INTO distritos (nombre) VALUES ('COMAS');
INSERT INTO distritos (nombre) VALUES ('EL AGUSTINO');
INSERT INTO distritos (nombre) VALUES ('INDEPENDENCIA');
INSERT INTO distritos (nombre) VALUES ('JESÚS MARÍA');
INSERT INTO distritos (nombre) VALUES ('LA MOLINA');
INSERT INTO distritos (nombre) VALUES ('LA VICTORIA');
INSERT INTO distritos (nombre) VALUES ('LINCE');
INSERT INTO distritos (nombre) VALUES ('LOS OLIVOS');
INSERT INTO distritos (nombre) VALUES ('LURIGANCHO');
INSERT INTO distritos (nombre) VALUES ('LURÍN');
INSERT INTO distritos (nombre) VALUES ('MAGDALENA DEL MAR');
INSERT INTO distritos (nombre) VALUES ('PUEBLO LIBRE');
INSERT INTO distritos (nombre) VALUES ('MIRAFLORES');
INSERT INTO distritos (nombre) VALUES ('PACHACAMAC');
INSERT INTO distritos (nombre) VALUES ('PUCUSANA');
INSERT INTO distritos (nombre) VALUES ('PUENTE PIEDRA');
INSERT INTO distritos (nombre) VALUES ('PUNTA HERMOSA');
INSERT INTO distritos (nombre) VALUES ('PUNTA NEGRA');
INSERT INTO distritos (nombre) VALUES ('RÍMAC');
INSERT INTO distritos (nombre) VALUES ('SAN BARTOLO');
INSERT INTO distritos (nombre) VALUES ('SAN BORJA');
INSERT INTO distritos (nombre) VALUES ('SAN ISIDRO');
INSERT INTO distritos (nombre) VALUES ('SAN JUAN DE LURIGANCHO');
INSERT INTO distritos (nombre) VALUES ('SAN JUAN DE MIRAFLORES');
INSERT INTO distritos (nombre) VALUES ('SAN LUIS');
INSERT INTO distritos (nombre) VALUES ('SAN MARTÍN DE PORRES');
INSERT INTO distritos (nombre) VALUES ('SAN MIGUEL');
INSERT INTO distritos (nombre) VALUES ('SANTA ANITA');
INSERT INTO distritos (nombre) VALUES ('SANTA MARÍA DEL MAR');
INSERT INTO distritos (nombre) VALUES ('SANTA ROSA');
INSERT INTO distritos (nombre) VALUES ('SANTIAGO DE SURCO');
INSERT INTO distritos (nombre) VALUES ('SURQUILLO');
INSERT INTO distritos (nombre) VALUES ('VILLA EL SALVADOR');
INSERT INTO distritos (nombre) VALUES ('VILLA MARÍA DEL TRIUNFO');

-- apoderados (30)
insert into apoderados (dni_apoderado, nombre, apellido, celular, correo, pass, distrito_id, estado) values (34887445, 'Dena', 'Cardnell', 900469120, 'dcardnell0@tuttocitta.it', 123, 39, 1);

-- estudiantes (42)
-- inicial (9)
-- 3 años (05/15/2016 - 02/28/2017)
-- A
-- B
-- C
-- 4 años (05/15/2015 - 02/28/2016)
-- A
-- B
-- C
-- 5 años (05/15/2014 - 02/28/2015)
-- A
-- B
-- C
-- primaria (18)
-- 1ro 6 (05/15/2013 - 02/28/2014)
-- A
-- B
-- C
-- 2do 7 (05/15/2012 - 02/28/2013)
-- A
-- B
-- C
-- 3ro 8 (05/15/2011 - 02/28/2012)
-- A
-- B
-- C
-- 4to 9 (05/15/2010 - 02/28/2011)
-- A
-- B
-- C
-- 5to 10 (05/15/2009 - 02/28/2010)
-- A
-- B
-- C
-- 6to 11 (05/15/2008 - 02/28/2009)
-- A
-- B
-- C
-- secundaria (15)
-- 1ro 12 (05/15/2007 - 02/28/2008)
-- A
-- B
-- C
-- 2do 13 (05/15/2006 - 02/28/2007)
-- A
-- B
-- C
-- 3ro 14 (05/15/2005 - 02/28/2006)
-- A
-- B
-- C
-- 4to 15 (05/15/2004 - 02/28/2005)
-- A
-- B
-- C
-- 5to 16 (05/15/2003 - 02/28/2004)
-- A
INSERT INTO estudiantes (dni_estudiante, nombre, apellido, fnacimiento, dni_apoderado, celular, correo, distrito_id, direccion, pass, estado, condicion) VALUES (61933011, 'Gabey', 'MacArd', '2003-10-14', 34887445, 945573734, 'gmacard0@usa.gov', 12, '42 Upham Way', 123, 1, 'promovido');
-- B
-- C

-- trabajadores (10)
-- directora
INSERT INTO trabajadores (cargo, nombres, apellidos, dni, fecha_nacimiento, celular, id_distrito, direccion, correo, pass) VALUES ('directora', 'Constantina', 'Wrightam', 32842520, '1986-01-12', 910727483, 7, '79 Loomis Court', 'cwrightam3@craigslist.org', 123);
-- recepcion (3)
INSERT INTO trabajadores (cargo, nombres, apellidos, dni, fecha_nacimiento, celular, id_distrito, direccion, correo, pass) VALUES ('recepcionista', 'Damaris', 'Breddy', 28606359, '1963-02-06', 903888102, 17, '092 Manufacturers Crossing', 'dbreddy0@jiathis.com', 123);
INSERT INTO trabajadores (cargo, nombres, apellidos, dni, fecha_nacimiento, celular, id_distrito, direccion, correo, pass) VALUES ('recepcionista', 'Noel', 'Mardlin', 21974639, '1983-12-20', 909967406, 32, '06 Birchwood Parkway', 'nmardlin1@goo.ne.jp', 123);
INSERT INTO trabajadores (cargo, nombres, apellidos, dni, fecha_nacimiento, celular, id_distrito, direccion, correo, pass) VALUES ('recepcionista', 'Analise', 'Shapero', 38343562, '1986-11-11', 912256458, 16, '19329 Summit Parkway', 'ashapero2@seesaa.net', 123);
-- docente (96)
INSERT INTO trabajadores (cargo, nombres, apellidos, dni, fecha_nacimiento, celular, id_distrito, direccion, correo, pass) VALUES ('docente', 'Elizabet', 'Edds', 32580790, '1983-06-11', 909204921, 21, '23 Towne Street', 'eedds4@google.de', 123);

-- nivel (3)
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

-- matricula ()
-- falta quitarle en acá el trabajador_id o agregar en spring trabajador_id
-- ---------------------------------------------------------------------------------
-- inicial ()
/*insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2007-02-25 22:12:34', 1, 1, 61933011, 1);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2008-02-25 22:12:34', 1, 2, 61933011, 2);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2009-02-25 22:12:34', 1, 3, 61933011, 3);
-- primaria ()
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2010-03-12 14:43:36', 2, 4, 61933011, 10);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2011-03-12 14:43:36', 2, 5, 61933011, 11);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2012-03-12 14:43:36', 2, 6, 61933011, 12);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2013-03-12 14:43:36', 2, 7, 61933011, 13);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2014-03-12 14:43:36', 2, 8, 61933011, 14);
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2015-03-12 14:43:36', 2, 9, 61933011, 15);
-- secundaria ()
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2016-03-12 14:43:36', 3, 10, 61933011, 28); -- 2016 - 1ro A 
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2017-03-12 14:43:36', 3, 11, 61933011, 29); -- 2017 - 2do A 
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2018-03-27 00:21:02', 3, 12, 61933011, 30); -- 2018 - 3ro A */
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2019-02-12 08:46:26', 3, 13, 61933011, 31); -- 2019 - 4to A 
insert into matriculas (fecha, nivel, grado, dni_estudiante, seccion_id) values ('2020-03-27 00:21:02', 3, 14, 61933011, 32); -- 2020 - 5to A

-- cursos (26)
-- inicial (6) http://www.minedu.gob.pe/curriculo/pdf/programa-curricular-educacion-inicial.pdf
INSERT INTO cursos (nombre, creditos) VALUES ('PERSONAL SOCIAL','1');
INSERT INTO cursos (nombre, creditos) VALUES ('PSICOMOTRIZ','2');
INSERT INTO cursos (nombre, creditos) VALUES ('COMUNICACIÓN','3');
INSERT INTO cursos (nombre, creditos) VALUES ('DESCUBRIMIENTO DEL MUNDO','4');
INSERT INTO cursos (nombre, creditos) VALUES ('MATEMÁTICA','5');
INSERT INTO cursos (nombre, creditos) VALUES ('CIENCIA Y TECNOLOGÍA','6');
 
-- primaria (8) http://www.minedu.gob.pe/curriculo/pdf/programa-nivel-primaria-ebr.pdf
INSERT INTO cursos (nombre, creditos) VALUES ('PERSONAL SOCIAL', '7');
INSERT INTO cursos (nombre, creditos) VALUES ('EDUCACIÓN FÍSICA',	'8');
INSERT INTO cursos (nombre, creditos) VALUES ('COMUNICACIÓN', '9');
INSERT INTO cursos (nombre, creditos) VALUES ('ARTE Y CULTURA', '10');
INSERT INTO cursos (nombre, creditos) VALUES ('INGLÉS', '11');
INSERT INTO cursos (nombre, creditos) VALUES ('MATEMÁTICA', '12');
INSERT INTO cursos (nombre, creditos) VALUES ('CIENCIA Y TECNOLOGÍA', '13');
INSERT INTO cursos (nombre, creditos) VALUES ('RELIGIÓN', '14');
	
-- secundaria (12) http://www.minedu.gob.pe/curriculo/pdf/03062016-programa-nivel-secundaria-ebr.pdf
INSERT INTO cursos (nombre, creditos) VALUES ('MATEMÁTICA','15');
INSERT INTO cursos (nombre, creditos) VALUES ('COMUNICACIÓN','16');
INSERT INTO cursos (nombre, creditos) VALUES ('CIENCIA TECNOLOGÍA Y AMBIENTE','17');
INSERT INTO cursos (nombre, creditos) VALUES ('RELIGIÓN','18');
INSERT INTO cursos (nombre, creditos) VALUES ('RELACIONES HUMANAS','19');
INSERT INTO cursos (nombre, creditos) VALUES ('FORMACIÓN CIUDADANA','20');
INSERT INTO cursos (nombre, creditos) VALUES ('HISTORIA','21');
INSERT INTO cursos (nombre, creditos) VALUES ('EDUCACIÓN FÍSICA','22');
INSERT INTO cursos (nombre, creditos) VALUES ('COMPUTACIÓN','23');
INSERT INTO cursos (nombre, creditos) VALUES ('ARTE','24');
INSERT INTO cursos (nombre, creditos) VALUES ('INGLÉS','25');
INSERT INTO cursos (nombre, creditos) VALUES ('EDUCACIÓN PARA EL TRABAJO','26');
 /*
-- cursos más específicos que creo no se tomarán en cuenta
    INSERT into cursos (nombre, creditos) VALUES ('GEOGRAFÍA','');
    INSERT into cursos (nombre, creditos) VALUES ('LENGUAJE','');
    INSERT into cursos (nombre, creditos) VALUES ('LITERATURA','5');	
    INSERT into cursos (nombre, creditos) VALUES ('ÁLGEBRA','');
    INSERT into cursos (nombre, creditos) VALUES ('ARITMÉTICA','');
    INSERT into cursos (nombre, creditos) VALUES ('TRIGONOMETRÍA','');
    INSERT into cursos (nombre, creditos) VALUES ('GEOMETRÍA','5');
    INSERT into cursos (nombre, creditos) VALUES ('FÍSICA','5');
    INSERT into cursos (nombre, creditos) VALUES ('QUÍMICA','');
    */

-- malla (14)
-- inicial
-- 3
INSERT INTO mallas (curso_id, grado_id) VALUES (1, 1);
INSERT INTO mallas (curso_id, grado_id) VALUES (2, 1);
INSERT INTO mallas (curso_id, grado_id) VALUES (3, 1);
INSERT INTO mallas (curso_id, grado_id) VALUES (4, 1);
INSERT INTO mallas (curso_id, grado_id) VALUES (5, 1);
INSERT INTO mallas (curso_id, grado_id) VALUES (6, 1);
-- 4
INSERT INTO mallas (curso_id, grado_id) VALUES (1, 2);
INSERT INTO mallas (curso_id, grado_id) VALUES (2, 2);
INSERT INTO mallas (curso_id, grado_id) VALUES (3, 2);
INSERT INTO mallas (curso_id, grado_id) VALUES (4, 2);
INSERT INTO mallas (curso_id, grado_id) VALUES (5, 2);
INSERT INTO mallas (curso_id, grado_id) VALUES (6, 2);
-- 5
INSERT INTO mallas (curso_id, grado_id) VALUES (1, 3);
INSERT INTO mallas (curso_id, grado_id) VALUES (2, 3);
INSERT INTO mallas (curso_id, grado_id) VALUES (3, 3);
INSERT INTO mallas (curso_id, grado_id) VALUES (4, 3);
INSERT INTO mallas (curso_id, grado_id) VALUES (5, 3);
INSERT INTO mallas (curso_id, grado_id) VALUES (6, 3);
-- primaria
-- 1
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 4);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 4);
-- 2
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 5);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 5);
-- 3
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 6);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 6);
-- 4
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 7);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 7);
-- 5
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 8);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 8);
-- 6
INSERT INTO mallas (curso_id, grado_id) VALUES (7, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (8, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (9, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (10, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (11, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (12, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (13, 9);
INSERT INTO mallas (curso_id, grado_id) VALUES (14, 9);
-- secundaria
-- 1
INSERT INTO mallas (curso_id, grado_id) VALUES (15, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (16, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (17, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (18, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (19, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (20, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (21, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (22, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (23, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (24, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (25, 10);
INSERT INTO mallas (curso_id, grado_id) VALUES (26, 10);
-- 2
INSERT INTO mallas (curso_id, grado_id) VALUES (15, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (16, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (17, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (18, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (19, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (20, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (21, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (22, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (23, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (24, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (25, 11);
INSERT INTO mallas (curso_id, grado_id) VALUES (26, 11);
-- 3
INSERT INTO mallas (curso_id, grado_id) VALUES (15, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (16, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (17, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (18, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (19, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (20, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (21, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (22, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (23, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (24, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (25, 12);
INSERT INTO mallas (curso_id, grado_id) VALUES (26, 12);
-- 4
INSERT INTO mallas (curso_id, grado_id) VALUES (15, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (16, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (17, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (18, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (19, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (20, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (21, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (22, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (23, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (24, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (25, 13);
INSERT INTO mallas (curso_id, grado_id) VALUES (26, 13);
-- 5
INSERT INTO mallas (curso_id, grado_id) VALUES (15, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (16, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (17, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (18, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (19, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (20, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (21, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (22, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (23, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (24, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (25, 14);
INSERT INTO mallas (curso_id, grado_id) VALUES (26, 14);

-- horario_cabecera
/* -- no lo he actualizado todavía
INSERT INTO horario_cabecera (trabajador_id, estado, seccion_id) VALUES (2,1,40);
*/
-- horario_detalle ()
/* -- no lo he actualizado todavía
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-07','LUNES','7:00:00','9:15:00',17,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-07','LUNES','10:00:00','11:30:00',4,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-08','MARTES','7:00:00','9:15:00',34,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-08','MARTES','10:00:00','12:15:00',32,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-09','MIÉRCOLES','7:00:00','8:30:00',24,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-09','MIÉRCOLES','8:30:00','9:15:00',26,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-09','MIÉRCOLES','10:00:00','11:30:00',21,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-10','JUEVES','7:00:00','8:30:00',34,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-10','JUEVES','8:30:00','9:15:00',25,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-10','JUEVES','10:00:00','11:30:00',29,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-11','VIERNES','7:00:00','9:15:00',33,1);
INSERT INTO horario_detalle (fecha, dia, hora_inicio, hora_fin, curso_id, id_horario_cabecera) VALUES ('2020-08-11','VIERNES','10:00:00','11:30:00',22,1);
*/

		
-- nota ()


-- 61933011 - 1ro A (cursos 15-26)
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (15, 15, 14, 14, '2016-11-13', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (16, 11, 15, 12, '2016-11-14', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (17, 19, 14, 14, '2016-11-28', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (18, 11, 10, 19, '2016-11-23', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (19, 19, 17, 20, '2016-08-28', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (20, 12, 16, 14, '2016-09-08', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (21, 14, 20, 19, '2016-10-10', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (22, 12, 11, 14, '2016-08-26', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (23, 10, 16, 16, '2016-08-20', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (24, 16, 14, 19, '2016-09-18', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (25, 15, 10, 18, '2016-09-08', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (26, 16, 10, 12, '2016-11-12', 61933011);
-- 61933011 - 2do A (cursos 15-26)
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (15, 20, 18, 15, '2017-09-28', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (16, 17, 19, 13, '2017-09-08', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (17, 17, 13, 18, '2017-09-01', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (18, 20, 13, 11, '2017-10-24', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (19, 13, 10, 17, '2017-09-27', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (20, 10, 20, 11, '2017-09-03', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (21, 13, 17, 10, '2017-11-03', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (22, 18, 19, 14, '2017-10-06', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (23, 16, 11, 10, '2017-09-04', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (24, 14, 14, 18, '2017-09-20', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (25, 11, 15, 14, '2017-11-01', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (26, 20, 10, 10, '2017-11-09', 61933011);
-- 61933011 - 3ro A (cursos 15-26)
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (15, 19, 13, 20, '2018-11-21', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (16, 13, 13, 10, '2018-11-30', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (17, 13, 11, 11, '2018-10-01', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (18, 18, 11, 12, '2018-08-30', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (19, 14, 13, 12, '2018-10-30', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (20, 15, 17, 14, '2018-08-22', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (21, 13, 20, 19, '2018-10-05', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (22, 20, 15, 13, '2018-12-06', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (23, 13, 12, 12, '2018-09-01', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (24, 16, 10, 11, '2018-10-21', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (25, 10, 16, 19, '2018-08-20', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (26, 12, 18, 11, '2018-09-26', 61933011);
-- 61933011 - 4to A (cursos 15-26)
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (15, 13, 19, 18, '2019-09-17', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (16, 13, 16, 17, '2019-12-03', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (17, 14, 19, 17, '2019-10-16', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (18, 10, 20, 17, '2019-11-14', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (19, 16, 11, 13, '2019-10-21', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (20, 12, 12, 19, '2019-10-03', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (21, 12, 16, 18, '2019-10-21', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (22, 10, 18, 20, '2019-11-25', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (23, 10, 15, 12, '2019-10-26', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (24, 17, 16, 10, '2019-10-26', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (25, 12, 18, 19, '2019-09-18', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (26, 17, 20, 10, '2019-12-06', 61933011);

-- 61933011 - 5to A (cursos 15-26)
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (15, 18, 20, 14, '2020-02-27', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (16, 20, 17, 14, '2020-03-03', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (17, 13, 15, 16, '2020-01-30', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (18, 19, 20, 17, '2020-01-24', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (19, 17, 16, 13, '2020-01-05', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (20, 18, 17, 16, '2020-01-12', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (21, 16, 16, 17, '2020-01-06', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (22, 18, 19, 16, '2020-01-18', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (23, 17, 20, 13, '2020-02-06', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (24, 14, 16, 16, '2020-12-25', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (25, 13, 16, 14, '2020-01-06', 61933011);
insert into notas (curso_id, nota1, nota2, nota3, fecha, dni_estudiante) values (26, 17, 19, 14, '2020-12-11', 61933011);

-- asistencia ()
/*
INSERT INTO asistencia (dni_estudiante, estado, hora_asistencia, id_horario_detalle) VALUES (15,'7:03:00',1,1);
*/

-- justificion ()
-- citaciones ()
-- permisos ()
-- comunicados ()

