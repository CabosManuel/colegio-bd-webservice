use bd_mpb;

SELECT * FROM curso;
select * from estudiante;
select * from grado;
select * from seccion;


-- listar nivel, grado y sesciones
select s.id_seccion, n.nombre as nivel, concat(g.nombre,' ',s.nombre) as 'grado y seccion'
from nivel n
inner join grado g on g.id_nivel = n.id_nivel
inner join seccion s on s.id_grado = g.id_grado;
