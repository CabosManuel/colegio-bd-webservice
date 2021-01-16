package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Asistencia;
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

	@Override
	public Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId) {
		return r.getAsistenciasByDniEstudianteMesCurso(dniEstudiante, mes, cursoId);
	}

	@Override
	public Collection<Object> getMesesByDniEstudiante(String dniEstudiante) {
		return r.getMesesByDniEstudiante(dniEstudiante);
	}

	@Transactional
	@Override
	public Asistencia insert(Asistencia asistencia) {
		return r.save(asistencia);
	}

}
