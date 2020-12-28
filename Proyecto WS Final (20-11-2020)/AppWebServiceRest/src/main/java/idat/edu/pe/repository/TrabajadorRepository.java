package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Trabajador;

public interface TrabajadorRepository extends CrudRepository<Trabajador, Integer>{
	
	@Query(value = "select t.trabajador_id, t.nombres, t.apellidos, t.cargo, t.dni, t.fecha_nacimiento, "
			+ "t.celular, t.direccion, t.correo, t.pass, t.estado, t.distrito_id from trabajadores t\r\n" + 
			"inner join trabajador_curso tc on t.trabajador_id = tc.trabajador_id\r\n" + 
			"inner join cursos c on tc.curso_id = c.curso_id\r\n" + 
			"where c.curso_id = ? ", nativeQuery = true)
	public abstract Collection<Trabajador> getfindByCurso(Integer cursoId);
}
