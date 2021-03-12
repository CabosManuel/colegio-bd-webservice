package com.colegio.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.colegio.model.HorarioCabecera;

public interface HorarioCabeceraRepository extends CrudRepository<HorarioCabecera, Integer> {

	@Query(value = "SELECT horario_cabecera_id \r\n" + "FROM horario_cabecera \r\n"
			+ "ORDER by horario_cabecera_id DESC \r\n" + "LIMIT 1", nativeQuery = true)
	Map<String, ?> getfindOneRegister();
}
