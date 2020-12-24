package idat.edu.pe.service;

import java.util.Collection;

public interface AsistenciaService {
	public Collection<Object[]> getAsistenciasByFecha(String fecha);
}
