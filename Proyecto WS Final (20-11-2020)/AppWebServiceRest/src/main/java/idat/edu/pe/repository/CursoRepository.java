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
	
	@Query(value = "select c.curso_id, c.nombre, c.creditos from cursos c\r\n" + 
			"inner join mallas m on c.curso_id = m.curso_id\r\n" + 
			"inner join grados g on g.grado_id = m.grado_id\r\n" + 
			"inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"where n.nivel_id = ? and g.grado_id = ?",nativeQuery = true)
	public abstract Collection<Curso> getfindByNivelGrado(Integer nivelId, Integer gradoId);
	
	
}
