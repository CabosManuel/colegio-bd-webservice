package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Integer>{
	
	@Query(value="select m.matricula_id, e.dni_estudiante, m.fecha, s.seccion_id, if(e.condicion = 'Promovido' and g.grado_id > 9, n.nivel_id + 1, n.nivel_id) as Nivel,\r\n" + 
			"			if(e.condicion = 'Promovido', g.grado_id + 1, g.grado_id) as Grado, s.seccion_id as Seccion\r\n" + 
			"			from matriculas m\r\n" + 
			"			inner join secciones s on m.seccion_id = s.seccion_id\r\n" + 
			"			inner join grados g on s.grado_id = g.grado_id\r\n" + 
			"			inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"			inner join estudiantes e on m.dni_estudiante = e.dni_estudiante\r\n" + 
			"			where e.dni_estudiante = ? ORDER by m.matricula_id DESC\r\n" + 
			"LIMIT 1", nativeQuery=true)
	public abstract Matricula findByEstudiante(String dniEstudiante);
}
