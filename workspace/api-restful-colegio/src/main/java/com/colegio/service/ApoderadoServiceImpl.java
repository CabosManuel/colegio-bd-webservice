package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.mapper.ApoderadoSimple;
import com.colegio.model.Apoderado;
import com.colegio.repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

	@Autowired
	private ApoderadoRepository r;

	@Transactional(readOnly = true)
	@Override
	public Collection<ApoderadoSimple> buscarTodos() {
		return r.buscarTodos();
	}

	@Transactional(readOnly = true)
	@Override
	public ApoderadoSimple buscarPorDni(String dni) {
		return r.buscarPorDni(dni);
	}

	@Transactional
	@Override
	public void nuevo(Apoderado a) {
		/*a.get("dniApoderado").toString(), a.get("nombre").toString(), a.get("apellido").toString(),
				a.get("celular").toString(), a.get("correo").toString(), a.get("pass").toString(),
				a.get("direccion").toString(), Boolean.parseBoolean(a.get("estado").toString()),
				Integer.parseInt(a.get("distrito_id").toString())*/
//		r.nuevo(a);
	}
	
	@Transactional
	@Override
	public void editar(String dni, Apoderado a) {
//		r.editar(dni, a);
	}

//	@Transactional(readOnly = true)
//	@Override
//	public Collection<Object[]> getNombreEstudiantesByDniApoderado(String dniApoderado) {
//		return r.getNombreEstudiantesByDniApoderado(dniApoderado);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Map<String, ?> loginApoderado(String dniApoderado, String pass) {
//		return r.loginApoderado(dniApoderado, pass);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public String findNomApeApoderadoByDniEstudiante(String dniEstudiante) {
//		return r.findNomApeApoderadoByDniEstudiante(dniEstudiante);
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Map<String, ?> buscarPorCorreo(String correo) {
//		return r.buscarPorCorreo(correo);
//
//	}
//
//	@Transactional(readOnly = true)
//	@Override
//	public Map<String, ?> buscarPorDniApoderado(String dniApoderado) {
//		return r.buscarPorDniApoderado(dniApoderado);
//	}
//

//
//	@Transactional(readOnly = true)
//	@Override
//	public Collection<Map<String, ?>> buscarApoderados() {
//		return r.buscarApoderados();
//	}
//
//
//	@Transactional
//	@Override
//	public void cambiarApoderado(Boolean estado, String dniApoderado) {
//		r.cambiarApoderado(estado, dniApoderado);
//	}
//

}
