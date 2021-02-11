package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;

import idat.edu.pe.model.Trabajador;

public interface TrabajadorService {
	public void insert(Trabajador trabajador);
	public void update(Trabajador trabajador);
	public void delete(Integer trabajadorId);
	public Trabajador findById(Integer trabajadorId);
	public Collection<Trabajador> findAll();
	
	public Collection<Map<String,Object>/*Trabajador*/> getfindByCurso(Integer cursoId);
	
	public Trabajador getfindByCorreoPass(String correo, String pass);
	
	Collection<Map<String, ?>> getfindByDniEstudiante(String dniEstudiante);

	Collection<Map<String, ?>> seleccionarCursos(Integer trabajadorId);
	
	Map<String, ?> obtenerPorCorreoPass(String correo, String pass);
	
	public abstract Trabajador findByUsername(String username);

}
