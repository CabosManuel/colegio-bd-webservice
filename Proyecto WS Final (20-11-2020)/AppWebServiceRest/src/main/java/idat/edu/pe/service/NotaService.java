package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.mapper.NotaMapper;

public interface NotaService {
	public Collection</*NotaMapper*/Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
}
