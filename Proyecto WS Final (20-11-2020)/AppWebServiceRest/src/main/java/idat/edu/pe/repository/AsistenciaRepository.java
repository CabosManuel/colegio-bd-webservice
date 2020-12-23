package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import idat.edu.pe.mapper.TestMapper;

public interface AsistenciaRepository {
	
	// Lisata si asisitió o en un més específico 
	@Query(value = "select a.estado, convert(a.asistencia,date) " + 
			"from asistencias a" + 
			"where week(a.asistencia)" + 
			"between week('2020-?-01') and (week(last_day('2020-?-01')))" + // entre semana del primer día del mes, hasta la semana  del último día de ese mes
			"group by dayofyear(convert(a.asistencia,date))",nativeQuery=true) // agrupado por día, porque en un día hay más de un curso
	public Collection<TestMapper> getAsistenciasByMes(String mes);
}
