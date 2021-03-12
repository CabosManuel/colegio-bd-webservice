package com.colegio.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.colegio.model.Trabajador;

public interface TrabajadorRepository extends CrudRepository<Trabajador, Integer>{
	
	@Query(value = "select t.trabajador_id, t.nombres, t.apellidos, t.cargo, t.dni, t.fecha_nacimiento, "
			+ "t.celular, t.direccion, t.correo, t.pass, t.estado, t.distrito_id, t.sexo from trabajadores t\r\n" + 
			"inner join trabajador_curso tc on t.trabajador_id = tc.trabajador_id\r\n" + 
			"inner join cursos c on tc.curso_id = c.curso_id\r\n" + 
			"where c.curso_id = ? ", nativeQuery = true)
	public abstract Collection<Map<String,Object>/*Trabajador*/> getfindByCurso(Integer cursoId);
	
	@Query(value = "select * from trabajadores where correo = ? and pass = ?", nativeQuery = true)
	public abstract Trabajador getfindByCorreoPass(String correo, String pass);
	
	@Query(value="select t.nombres, t.apellidos, t.celular, t.correo, t.sexo, c.nombre as curso " +
			"from trabajadores t "+
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
	
	@Query(value = "select t.trabajador_id, t.nombres, t.apellidos, t.cargo, t.dni, t.fecha_nacimiento "
			+ "from trabajadores t where t.correo = ? and t.pass = ?", nativeQuery = true)
	Map<String, ?> obtenerPorCorreoPass(String correo, String pass);
	
	@Query(value="select * from trabajadores where correo=?",nativeQuery=true)
	public abstract Trabajador findByUsername(String username);
	
	@Query(value = "select t.trabajador_id, t.nombres, t.apellidos, t.cargo, t.dni, t.fecha_nacimiento, "
			+ "t.celular, t.correo, t.pass, t.direccion, t.estado, d.distrito_id, d.nombre as nomdistrito, t.sexo from trabajadores t\r\n" + 
			"inner join distritos d on t.distrito_id = d.distrito_id ", nativeQuery = true)
	Collection<Map<String, ?>> buscarTrabajadores();
	
	@Query(value = "select t.trabajador_id, t.nombres, t.apellidos, t.cargo, t.dni, t.fecha_nacimiento, "
			+ "t.celular, t.correo, t.pass, t.estado, t.direccion, d.distrito_id, t.sexo from trabajadores t\r\n" + 
			"  inner join distritos d on t.distrito_id = d.distrito_id "
			+" where t.dni = ?", nativeQuery = true)
	Map<String, ?> buscarTrabajador(String dniApoderado);
	
	@Modifying
	@Query(value = "update trabajadores set estado = ?1 where dni = ?2", 
				   nativeQuery = true)
	void cambiarTrabajador(Boolean estado, String dni);
	
	/*@Modifying
	@Query(value = "update estudiantes set nombres = ?1, apellidos = ?2, celular = ?3, correo = ?3" +
				   "fnacimiento = ?4, correo = ?5, distrito_id = ?6, direccion = ?7 where dni_estudiante = ?8", 
				   nativeQuery = true)
	void modificarTrabajador(String nombre, String apellido, String celular, String correo, String fnacimiento, 
			Integer distrito_id, String direccion, String cargo, String dni);
			*/
	
	@Modifying
	@Query(value = "insert into trabajadores" +
	       "(dni, nombres, apellidos, celular, correo, fecha_nacimiento, distrito_id, direccion, pass, estado, cargo, sexo) values " + 
	       "(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery = true)
	void registrarTrabajador(String dni, String nombre, String apellido, String celular, String correo, String fnacimiento, 
			Integer distrito_id, String direccion, String pass, Boolean estado, String cargo, String sexo);
}
