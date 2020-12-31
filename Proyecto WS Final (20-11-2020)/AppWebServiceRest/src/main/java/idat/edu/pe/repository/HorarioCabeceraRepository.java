package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.HorarioCabecera;

public interface HorarioCabeceraRepository extends CrudRepository<HorarioCabecera, Integer>{

	@Query(value="SELECT *\r\n" + 
			"FROM horario_cabecera\r\n" + 
			"ORDER by horario_cabecera_id DESC\r\n" + 
			"LIMIT 1", nativeQuery=true)
	public abstract HorarioCabecera getfindOneRegister();
}
