package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.repository.AsistenciaRepository;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{

	@Autowired
	private AsistenciaRepository r;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha) {
		return r.getAsistenciasByDniEstudianteFecha(dniEstudiante, fecha);
	}

}
