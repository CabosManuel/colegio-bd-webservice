package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Trabajador;

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

	Map<String, ?> buscarTrabajador(String dniApoderado);
	
	Collection<Map<String, ?>> buscarTrabajadores();
	
	void cambiarTrabajador(Boolean estado, String dni);
	
	void registrarTrabajador(String dni, String nombre, String apellido, String celular, String correo, String fnacimiento, 
			Integer distrito_id, String direccion, String pass, Boolean estado, String cargo, String sexo);
}
