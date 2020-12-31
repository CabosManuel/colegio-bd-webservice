package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Curso;
import idat.edu.pe.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository r;

	@Override
	public Collection<Object[]> findByDniEstudiante(String dniEstudiante) {
		return r.findByDniEstudiante(dniEstudiante);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Curso> getfindByNivelGrado(Integer nivelId, Integer gradoId) {
		return r.getfindByNivelGrado(nivelId, gradoId);
	}

	@Transactional(readOnly = true)
	@Override
	public Curso findById(Integer cursoId) {
		return r.findById(cursoId).orElse(null);
	}
}
