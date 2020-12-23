package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer>{
	@Query(value = "select cu.curso_id, cu.nombre from cursos cu " + 
			"inner join mallas mll1 on mll1.curso_id = cu.curso_id " + 
			"inner join grados g on g.grado_id = mll1.grado_id " + 
			"inner join matriculas mtr on mtr.grado = g.grado_id " + 
			"inner join estudiantes e on e.dni_estudiante = mtr.dni_estudiante " + 
			"where e.dni_estudiante = ? and year(mtr.fecha) like year(now());",nativeQuery = true)
	public abstract Collection<Object[]> findByDniEstudiante(String dniEstudiante);
}
