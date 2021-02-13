package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{

	@Autowired
	private ApoderadoRepository r;
	
	@Transactional
	@Override
	public void insert(Apoderado apoderado) {
		r.save(apoderado);
	}

	@Transactional
	@Override
	public void update(Apoderado apoderado) {
		r.save(apoderado);		
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Apoderado> findAll() {
		return (Collection<Apoderado>)r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Apoderado findByDniApoderado(String dniApoderado) {
		return r.findByDniApoderado(dniApoderado);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Object[]> getEstudiantesByDniApoderado(String dniApoderado) {
		return r.getEstudiantesByDniApoderado(dniApoderado);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> loginApoderado(String dniApoderado, String pass){
		return r.loginApoderado(dniApoderado, pass);
	}
	
	@Transactional(readOnly = true)
	@Override
	public String findNomApeApoderadoByDniEstudiante(String dniEstudiante) {
		return r.findNomApeApoderadoByDniEstudiante(dniEstudiante);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarPorCorreo(String correo) {
		return r.buscarPorCorreo(correo);

	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarPorDniApoderado(String dniApoderado) {
		return r.buscarPorDniApoderado(dniApoderado);
	}
	
	@Transactional
	@Override
	public void nuevoApoderado(Map<String, Object> a) {
		System.out.println(a.get("distrito_id"));
		
		r.nuevoApoderado(
				a.get("dniApoderado").toString(),
				a.get("nombre").toString(),
				a.get("apellido").toString(),
				a.get("celular").toString(),
				a.get("correo").toString(),
				a.get("pass").toString(),
				a.get("direccion").toString(),
				Boolean.parseBoolean(a.get("estado").toString()),
				Integer.parseInt(a.get("distrito_id").toString()));
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> buscarApoderados() {
		return r.buscarApoderados();
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarApoderado(String dniApoderado) {
		return r.buscarApoderado(dniApoderado);
	}
	
	@Transactional
	@Override
	public void cambiarApoderado(Boolean estado, String dniApoderado) {
		r.cambiarApoderado(estado, dniApoderado);
	}

	@Transactional
	@Override
	public void modificarApoderado(String nombre, String apellido, String celular, String correo, Integer distritoId,
			String direccion, String dniApoderado) {
		r.modificarApoderado(nombre, apellido, celular, correo, distritoId, direccion, dniApoderado);
		
	}
	
}
