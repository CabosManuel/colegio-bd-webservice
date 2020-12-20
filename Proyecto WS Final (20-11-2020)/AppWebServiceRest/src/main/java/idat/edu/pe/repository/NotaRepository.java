package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Nota;

public interface NotaRepository extends CrudRepository<Nota, Integer>{
	
	@Query(value = "select distinct c.nombre,n.nota1,n.nota2,n.nota3 from notas n inner join cursos c on c.curso_id=n.curso_id inner join estudiantes e on e.dni_estudiante = n.dni_estudiante where year(n.fecha) = ?2 and e.dni_estudiante = ?1",nativeQuery = true)
	public abstract Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
	
	@Query(value = "select distinct year(n.fecha) from notas n inner join estudiantes e on e.dni_estudiante = n.dni_estudiante where e.dni_estudiante = ?",nativeQuery = true)
	public abstract Collection<Object> getAniosByDniEstudiante(String dniEstudiante);
}