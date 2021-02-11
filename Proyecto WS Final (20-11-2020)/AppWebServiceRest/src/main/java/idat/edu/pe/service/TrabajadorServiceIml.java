package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Trabajador;
import idat.edu.pe.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceIml implements TrabajadorService{
	
	@Autowired
	private TrabajadorRepository r;

	@Transactional
	@Override
	public void insert(Trabajador trabajador) {
		r.save(trabajador);		
	}

	@Transactional
	@Override
	public void update(Trabajador trabajador) {
		r.save(trabajador);
	}

	@Transactional
	@Override
	public void delete(Integer trabajadorId) {
		r.deleteById(trabajadorId);
	}

	@Transactional(readOnly = true)
	@Override
	public Trabajador findById(Integer trabajadorId) {
		return r.findById(trabajadorId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Trabajador> findAll() {
		return (Collection<Trabajador>) r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Collection</*Trabajador*/Map<String,Object>> getfindByCurso(Integer cursoId) {
		return (Collection</*Trabajador*/Map<String,Object>>)r.getfindByCurso(cursoId);
	}

	@Transactional(readOnly = true)
	@Override
	public Trabajador getfindByCorreoPass(String correo, String pass) {
		return r.getfindByCorreoPass(correo, pass);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> getfindByDniEstudiante(String dniEstudiante){
		return r.getfindByDniEstudiante(dniEstudiante);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> seleccionarCursos(Integer trabajadorId) {
		return r.seleccionarCursos(trabajadorId);

	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> obtenerPorCorreoPass(String correo, String pass) {
		return r.obtenerPorCorreoPass(correo, pass);
	}
}
