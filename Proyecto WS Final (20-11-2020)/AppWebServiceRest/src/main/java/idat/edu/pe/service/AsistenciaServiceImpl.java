package idat.edu.pe.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

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
	public void insert(Asistencia asistencia) {
		r.save(asistencia);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> buscarPorHorario(Integer horarioDetalleId) {
		return r.buscarPorHorario(horarioDetalleId);
	}

	@Transactional
	@Override
	public void update(Asistencia asistencia) {
		r.save(asistencia);
	}

	@Transactional(readOnly = true)
	@Override
	public Asistencia findById(Integer asistenciaId) {
		return r.findById(asistenciaId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarPorId(Integer asistenciaId) {
		return r.buscarPorId(asistenciaId);
	}

	@Transactional
	@Override
	public void registrarAsistencia(LocalDateTime asistencia, Boolean estado, String dni_estudiante,
			String horario_detalle_id) {
		r.registrarAsistencia(asistencia, estado, dni_estudiante, horario_detalle_id);
	}

	@Transactional
	@Override
	public void modificarAsistencia(LocalDateTime asistencia, Boolean estado, Integer asistenciaId) {
		r.modificarAsistencia(asistencia, estado, asistenciaId);
	}

}
