package idat.edu.pe.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Integer>{
	
	@Query(value="select m.matricula_id, e.dni_estudiante, m.fecha, if(e.condicion = 'Promovido' and ((n.nivel_id = 1 and g.grado_id = 3) or "
			+ " (n.nivel_id = 2 and g.grado_id = 9)), n.nivel_id + 1, n.nivel_id) as Nivel, n.nombre as NombreNivel, \r\n"
			+ "						if(e.condicion = 'Promovido', g.grado_id + 1, g.grado_id) as Grado, g.nombre as NombreGrado, s.seccion_id as Seccion \r\n"
			+ "						from matriculas m \r\n"
			+ "						inner join secciones s on m.seccion_id = s.seccion_id \r\n"
			+ "						inner join grados g on s.grado_id = g.grado_id \r\n"
			+ "						inner join niveles n on g.nivel_id = n.nivel_id \r\n"
			+ "						inner join estudiantes e on m.dni_estudiante = e.dni_estudiante \r\n"
			+ "						where e.dni_estudiante = ?\r\n"
			+ "                        ORDER by m.matricula_id DESC LIMIT 1", nativeQuery=true)
	Map<String, ?> findByEstudiante(String dniEstudiante);
	
	@Modifying
	@Query(value = "insert into matriculas" +
	       "(grado, nivel, seccion_id, dni_estudiante) values " + 
	       "(?1, ?2, ?3, ?4)", nativeQuery = true)
	void registrarMatricula(String grado, String nivel, String seccionId, String dniEstudiante);
}
