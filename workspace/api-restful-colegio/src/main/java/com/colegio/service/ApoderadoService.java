package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.mapper.ApoderadoSimple;
import com.colegio.model.Apoderado;

public interface ApoderadoService {

	Collection<ApoderadoSimple> buscarTodos();
	ApoderadoSimple buscarPorDni(String dni);
	void nuevo(Apoderado a);
	void editar(String dni, Apoderado a);
	

//
//
//	
//	
//	
//	Collection<Object[]> getNombreEstudiantesByDniApoderado(String dniApoderado);
//
//	Map<String, ?> loginApoderado(String dniApoderado, String pass);
//
//	String findNomApeApoderadoByDniEstudiante(String dniEstudiante);
//
//	Map<String, ?> buscarPorCorreo(String correo);
//
//	Map<String, ?> buscarPorDniApoderado(String dniApoderado);
//
//	void nuevoApoderado(Map<String, Object> apoderado);
//
//	Map<String, ?> buscarApoderado(String dniApoderado);
//
//	void cambiarApoderado(Boolean estado, String dniApoderado);
//
}
