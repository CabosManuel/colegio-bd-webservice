package com.colegio.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.colegio.mapper.ApoderadoSimple;
import com.colegio.model.Apoderado;

public interface ApoderadoRepository extends CrudRepository<Apoderado, String> {
	
	@Query(value = "select new "+/*com.colegio.mapper.*/"ApoderadoSimple(a.dni, a.nombres, a.apellidos, a.correo,"
			 	 + "a.celular, a.direccion, a.distrito) "
			 	 + "from Apoderado as a")
	Collection<ApoderadoSimple> buscarTodos();

	@Query(value = "select new com.colegio.mapper.ApoderadoSimple(a.dni, a.nombres, a.apellidos, a.correo,"
		 	 	 + "a.celular, a.direccion, a.distrito) "
		 	 	 + "from Apoderado as a "
		 	 	 + "where a.dni = :dni")
	ApoderadoSimple buscarPorDni(String dni);
	
//	@Modifying
//	@Query(value = "insert into Apoderado")
//	/*@Query(value = "insert into apoderado (dni_apoderado, nombre, apellido, celular, correo, pass, direccion, estado, distrito_id) "
//			+ "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9);", nativeQuery = true)
//	void nuevoApoderado(String dni_apoderado, String nombre, String apellido, String celular, String correo,
//			String pass, String direccion, boolean estado, int distrito_id);*/
//	
//	@Modifying
//	@Query(value = "update Apoderado set nombres = :#{#a.nombres}, apellidos = :#{#a.apellidos} "
//				 + "where dni = :dni")
//	void editar(String dni, Apoderado a);
	
	

//
//	@Query(value = "select e.dni_estudiante, e.nombre " 
//				 + "from estudiantes e "
//				 + "where e.dni_apoderado like ? ", nativeQuery = true)
//	Collection<Object[]> getNombreEstudiantesByDniApoderado(String dniApoderado);
//
//	@Query(value = "select * from apoderado a "
//			+ "where a.dni_apoderado like ?1 and a.pass like ?2", nativeQuery = true)
//	Map<String, ?> loginApoderado(String dniApoderado, String pass);
//
//	@Query(value = "SELECT CONCAT(a.nombre, \" \", a.apellido) AS apoderado " + "FROM apoderado a "
//			+ "INNER JOIN estudiantes e ON e.dni_apoderado LIKE a.dni_apoderado "
//			+ "WHERE e.dni_estudiante LIKE ?", nativeQuery = true)
//	String findNomApeApoderadoByDniEstudiante(String dniEstudiante);
//
//	@Query(value = "select a.dni_apoderado, a.nombre, a.apellido from apoderado a "
//			+ "where a.correo like ?", nativeQuery = true)
//	Map<String, ?> buscarPorCorreo(String correo);
//
//	@Query(value = "select nombre, apellido, dni_apoderado "
//			+ "from apoderado where dni_apoderado = ?", nativeQuery = true)
//	Map<String, ?> buscarPorDniApoderado(String dniApoderado);
//

//
//
//	@Query(value = "select dni_apoderado, apellido, nombre, correo, celular, pass, estado, direccion, distrito_id"
//			+ " from apoderado where dni_apoderado = ?", nativeQuery = true)
//	Map<String, ?> buscarApoderado(String dniApoderado);
//
//	@Modifying
//	@Query(value = "update apoderado set estado = ?1 where dni_apoderado = ?2", nativeQuery = true)
//	void cambiarApoderado(Boolean estado, String dniApoderado);

}
