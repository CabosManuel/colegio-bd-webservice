package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Nota;

public interface NotaRepository extends CrudRepository<Nota, Integer>{
	
	@Query(value = "select distinct c.nombre,n.nota1,n.nota2,n.nota3 from notas n inner join cursos c on c.curso_id=n.curso_id inner join estudiantes e on e.dni_estudiante = n.dni_estudiante where year(n.fecha) = ?2 and e.dni_estudiante = ?1",nativeQuery = true)
	public abstract Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
	
	@Query(value = "select distinct year(n.fecha) from notas n inner join estudiantes e on e.dni_estudiante = n.dni_estudiante where e.dni_estudiante = ?",nativeQuery = true)
	public abstract Collection<Object> getAniosByDniEstudiante(String dniEstudiante);
	
	@Query(value = "select n.nota_id, s.seccion_id, c.curso_id, e.dni_estudiante, n.fecha, c.nombre, n.nota1, n.nota2, "
			+ "n.nota3 from notas n inner join cursos c on n.curso_id = c.curso_id "
			+ "inner join estudiantes e on n.dni_estudiante = e.dni_estudiante\r\n" 
			+ "inner join secciones s on n.seccion_id = s.seccion_id "
			+ "where e.dni_estudiante = ?",nativeQuery = true)
	public abstract Collection<Nota> findByDniEstudiante(String dniEstudiante);
	
	@Query(value="select e.dni_estudiante, e.nombre, e.apellido, n.fecha, n.nota1, n.nota2, n.nota3 from notas n\r\n"
			+ "			inner join estudiantes e on e.dni_estudiante = n.dni_estudiante\r\n"
			+ "            inner join cursos c on n.curso_id = c.curso_id\r\n"
			+ "            inner join secciones s on n.seccion_id = s.seccion_id \r\n"
			+ "			where n.curso_id like ?1 and s.seccion_id like ?2", nativeQuery=true)
	Collection<Map<String, ?>> buscarNotasPorCurso(Integer cursoId, Integer seccionId);
	
	@Query(value = "select n.nota_id, s.seccion_id, c.curso_id, e.dni_estudiante, n.fecha, n.nota1, n.nota2, n.nota3 from notas n\r\n"
			+ "inner join cursos c on n.curso_id = c.curso_id \r\n"
			+ "inner join estudiantes e on n.dni_estudiante = e.dni_estudiante\r\n"
			+ "inner join secciones s on n.seccion_id = s.seccion_id "
			+ "where n.nota_id like ?",nativeQuery = true)
	Map<String, ?> buscarPorId(Integer notaId);
}
