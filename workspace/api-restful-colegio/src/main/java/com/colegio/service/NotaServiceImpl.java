package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.colegio.model.Nota;
//import com.colegio.repository.NotaRepository;

@Service
public class NotaServiceImpl /*implements NotaService*/ {

//	@Autowired
//	private NotasRepository r;
//
//	@Override
//	@Transactional(readOnly = true)
//	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio) {
//		return r.findByDniEstudianteAnio(dniEstudiante, anio);
//	}
//
//	@Override
//	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante) {
//		return r.getAniosByDniEstudiante(dniEstudiante);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Collection<Nota> findByDniEstudiante(String dniEstudiante) {
//		return (Collection<Nota>) r.findByDniEstudiante(dniEstudiante);
//	}
//
//	@Transactional
//	@Override
//	public void insert(Nota nota) {
//		r.save(nota);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Collection<Map<String, ?>> buscarNotasPorCurso(Integer cursoId, Integer seccionId) {
//		return r.buscarNotasPorCurso(cursoId, seccionId);
//	}
//
//	@Transactional
//	@Override
//	public void update(Nota nota) {
//		r.save(nota);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Map<String, ?> buscarPorId(Integer notaId) {
//		return r.buscarPorId(notaId);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Nota findById(Integer notaId) {
//		return r.findById(notaId).orElse(null);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Collection<Map<String, ?>> DniEstudiante(String dniEstudiante) {
//		return (Collection<Map<String, ?>>) r.DniEstudiante(dniEstudiante);
//	}
//
//	@Transactional
//	@Override
//	public void registrarNota(Integer seccionId, Integer cursoId, String dniEstudiante, Integer nota1, String fecha) {
//		r.registrarNota(seccionId, cursoId, dniEstudiante, nota1, fecha);
//
//	}
//
//	@Transactional
//	@Override
//	public void modificarNota(String fecha, Integer nota1, Integer nota2, Integer nota3, Integer notaId) {
//		r.modificarNota(fecha, nota1, nota2, nota3, notaId);
//	}

}
