package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
	
	@Query(value = "select * from estudiantes where dni_estudiante = ?", nativeQuery = true)
	public abstract Estudiante findByDniEstudiante(String dniEstudiante);
	
	public Estudiante findByDniEstudianteAndPass(String dniEstudiante, String pass);
	
	@Query(value = "SELECT e.dni_estudiante, e.nombre, e.apellido " + 
			"from estudiantes e " + 
			"where e.dni_apoderado like ?", nativeQuery = true)
	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);
	
	/*@Query(name = "update estudiantes set estado = false where dni_estudiante =?", nativeQuery = true)
	public abstract void actualizarEstado(String dniEstudiante);*/
	
	@Query(value="select * from estudiantes e\r\n" + 
			"inner join matriculas m on e.dni_estudiante = m.dni_estudiante\r\n" + 
			"inner join secciones s on m.seccion_id = s.seccion_id\r\n" + 
			"where s.seccion_id = ?", nativeQuery=true)
	public abstract Collection<Estudiante> getfindByEstudianteSeccion(Integer seccionId);

	@Query(value = "select * from estudiantes where correo = ?", nativeQuery = true)
	public abstract Estudiante findByCorreo(String correo);

}
