package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

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
	
	@Query(value = "select * from trabajadores where correo = ? and pass = ?", nativeQuery = true)
	public abstract Trabajador getfindByCorreoPass(String correo, String pass);
	
	@Query(value="select t.nombres , t.apellidos , t.celular , t.correo , t.sexo, c.nombre from trabajadores t "+
			"inner join trabajador_curso tc on tc.trabajador_id = t.trabajador_id "+
			"inner join cursos c on c.curso_id = tc.curso_id "+
			"inner join mallas mll on mll.curso_id = c.curso_id "+
			"inner join grados g on g.grado_id = mll.grado_id "+
			"inner join matriculas mtr on mtr.grado = g.grado_id "+
			"inner join estudiantes e on e.dni_estudiante = mtr.dni_estudiante "+
			"where t.cargo = 'docente' and "+
			"e.dni_estudiante = ? and "+
			"year(mtr.fecha) = 2020", nativeQuery = true)			
	Collection<Map<String, ?>> getfindByDniEstudiante(String dniEstudiante);

	@Query(value="select c.curso_id, c.nombre as Curso, n.nivel_id, n.nombre as Nivel, g.grado_id, "
			+ "         g.nombre as Grado, s.seccion_id, s.nombre as Seccion\r\n"
			+ "			from horario_cabecera hc\r\n"
			+ "			inner join horario_detalle hd on hc.horario_cabecera_id = hd.horario_cabecera_id\r\n"
			+ "            inner join cursos c on hd.curso_id = c.curso_id\r\n"
			+ "			inner join secciones s on hc.seccion_id = s.seccion_id\r\n"
			+ "            inner join grados g on s.grado_id = g.grado_id\r\n"
			+ "            inner join niveles n on g.nivel_id = n.nivel_id\r\n"
			+ "			inner join trabajadores t on hd.trabajador_id = t.trabajador_id\r\n"
			+ "			where t.trabajador_id = ?", nativeQuery=true)
	Collection<Map<String, ?>> seleccionarCursos(Integer trabajadorId);
}
