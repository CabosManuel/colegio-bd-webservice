package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository r;

	@Override
	public Collection<Object[]> findByDniEstudiante(String dniEstudiante) {
		return r.findByDniEstudiante(dniEstudiante);
	}
}
